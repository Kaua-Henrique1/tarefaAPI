package br.edu.ifrn.tarefa.dto;

import lombok.Builder;

@Builder
public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String cargo
) {
}
