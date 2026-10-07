package br.edu.ifrn.tarefa.mapper;

import br.edu.ifrn.tarefa.dto.UsuarioRequestDTO;
import br.edu.ifrn.tarefa.dto.UsuarioResponseDTO;
import br.edu.ifrn.tarefa.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        return Usuario.builder().nome(dto.nome()).email(dto.email()).cargo(dto.cargo()).build();
    }

    public UsuarioResponseDTO toDTO(Usuario entity) {
        if (entity == null) {
            return null;
        }

        return UsuarioResponseDTO.builder().id(
                entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .cargo(entity.getCargo())
                .build();
    }
}