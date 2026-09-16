package br.edu.ifrn.tarefa.strategy;

import br.edu.ifrn.tarefa.model.Tarefa;

public class LowPriorityStrategy implements PriorityStrategy {
    public String calcularPrioridade(Tarefa tarefa) {
        return "BAIXA";
    }
}