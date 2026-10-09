package br.edu.ifrn.tarefa.service;

import br.edu.ifrn.tarefa.dto.UsuarioRequestDTO;
import br.edu.ifrn.tarefa.dto.UsuarioResponseDTO;
import br.edu.ifrn.tarefa.mapper.UsuarioMapper;
import br.edu.ifrn.tarefa.model.Usuario;
import br.edu.ifrn.tarefa.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {

        if (repository.equals(dto)) {
            throw new RuntimeException("Já existe um usuário cadastrado com esses parâmetros " + dto.nome());
        }

        Usuario entidy = usuarioMapper.toEntity(dto);
        Usuario salva = repository.save(entidy);
        return usuarioMapper.toDTO(salva);
    }

    public List<UsuarioResponseDTO> listarTodas() {

        return repository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
         Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID:" + id));
        return usuarioMapper.toDTO(usuario);
    }


    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID do Usuário não encontrada"));
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioResponseDTO deletar(Long id) {
        Usuario deleta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID do Usuário não encontrada"));
        repository.delete(deleta);
        return usuarioMapper.toDTO(deleta);
    }
}
