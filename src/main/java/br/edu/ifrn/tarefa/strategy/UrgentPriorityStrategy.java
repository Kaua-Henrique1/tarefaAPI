package br.edu.ifrn.tarefa.strategy;

import br.edu.ifrn.tarefa.model.Tarefa;

public class UrgentPriorityStrategy implements PriorityStrategy {
    @Override
    public String calcularPrioridade(Tarefa tarefa) {
        return "URGENTE";
    }
}