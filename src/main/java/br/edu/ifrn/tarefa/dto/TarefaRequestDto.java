package br.edu.ifrn.tarefa.dto;

import java.time.LocalDate;

public record TarefaRequestDto(String titulo, String descricao, LocalDate prazo) {
}
