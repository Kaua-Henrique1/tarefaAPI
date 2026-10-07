package br.edu.ifrn.tarefa.dto;

import br.edu.ifrn.tarefa.model.Prioridade;
import lombok.Builder;

@Builder
public record TarefaResponseDto(Long id, String titulo, boolean concluida, Prioridade prioridade) {
}
