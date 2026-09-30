package br.edu.ifrn.tarefa.dto;

import br.edu.ifrn.tarefa.model.Prioridade;

public record TarefaRequestDto(String titulo, String descricao, Prioridade prioridade) {
}
