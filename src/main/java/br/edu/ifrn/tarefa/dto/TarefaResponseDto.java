package br.edu.ifrn.tarefa.dto;

public record TarefaResponseDto(Long id, String titulo, boolean concluida, String prioridade) {
}
