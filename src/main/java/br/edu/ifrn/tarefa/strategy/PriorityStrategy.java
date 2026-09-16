package br.edu.ifrn.tarefa.strategy;

import br.edu.ifrn.tarefa.model.Tarefa;

public interface PriorityStrategy {
    String calcularPrioridade(Tarefa tarefa);
}

