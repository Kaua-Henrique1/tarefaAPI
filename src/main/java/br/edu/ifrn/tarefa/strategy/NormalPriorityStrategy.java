package br.edu.ifrn.tarefa.strategy;

import br.edu.ifrn.tarefa.model.Tarefa;

public class NormalPriorityStrategy  implements PriorityStrategy {
    public String calcularPrioridade(Tarefa tarefa) {
        return "NORMAL";
    }
}
