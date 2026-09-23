package br.edu.ifrn.tarefa.service;

import br.edu.ifrn.tarefa.dto.UsuarioRequestDTO;
import br.edu.ifrn.tarefa.dto.UsuarioResponseDTO;
import br.edu.ifrn.tarefa.model.Usuario;
import br.edu.ifrn.tarefa.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario(
                dto.nome(),
                dto.email(),
                dto.cargo()
                );

        Usuario salva = repository.salvar(usuario);
        return toResponseDto(salva);
    }



    public List<UsuarioResponseDTO> listarTodas() {
        return repository.listarTodas().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrada"));
        return toResponseDto(usuario);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuarioNovo = new Usuario(
                dto.nome(),
                dto.email(),
                dto.cargo()
        );

        Usuario salva = repository.atualizar(id, usuarioNovo)
                .orElseThrow(() -> new RuntimeException("ID do Usuario não encontrada"));
        return toResponseDto(salva);
    }

    public UsuarioResponseDTO deletar(Long id) {
        Usuario usuario = repository.deletar(id)
                .orElseThrow(() -> new RuntimeException("ID do Usuario não encontrada"));
        return toResponseDto(usuario);
    }

    private UsuarioResponseDTO toResponseDto(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCargo(),
                usuario.getEmail()
        );
    }

}
