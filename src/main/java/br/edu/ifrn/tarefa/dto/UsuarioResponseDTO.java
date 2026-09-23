package br.edu.ifrn.tarefa.dto;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String cargo
) {
}
