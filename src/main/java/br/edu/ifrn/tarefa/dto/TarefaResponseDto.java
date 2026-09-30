package br.edu.ifrn.tarefa.dto;

import br.edu.ifrn.tarefa.model.Prioridade;

public record TarefaResponseDto(Long id, String titulo, boolean concluida, Prioridade prioridade) {
}
