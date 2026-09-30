package br.edu.ifrn.tarefa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefas")
@Setter
@Getter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    private boolean concluida;

    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, String descricao, Prioridade prioridade, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    public Tarefa(String titulo, boolean concluida, String descricao, Prioridade prioridade) {
        this.titulo = titulo;
        this.concluida = concluida;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }
}