package br.edu.ifrn.tarefa.model;

import java.time.LocalDate;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private String prioridade;
    private boolean concluida;
    private LocalDate prazo;

    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, String descricao, String prioridade, boolean concluida, LocalDate prazo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = concluida;
        this.prazo = prazo;
    }

    public Tarefa(String titulo, boolean concluida, LocalDate prazo, String descricao, String prioridade) {
        this.titulo = titulo;
        this.concluida = concluida;
        this.prazo = prazo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }
}