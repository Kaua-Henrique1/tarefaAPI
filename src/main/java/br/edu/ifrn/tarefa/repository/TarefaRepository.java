package br.edu.ifrn.tarefa.repository;

import br.edu.ifrn.tarefa.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class TarefaRepository {

    private final Map<Long, Tarefa> banco = new LinkedHashMap<>();
    private final AtomicLong sequencia = new AtomicLong();

    public Tarefa salvar(Tarefa tarefa) {
        System.out.println("[REPOSITORY] Salvando tarefa em memória: " + tarefa.getTitulo());
        Long id = sequencia.incrementAndGet();
        tarefa.setId(id);
        banco.put(id, tarefa);
        return tarefa;
    }

    public Tarefa salvar(String titulo) {
        Tarefa tarefa = new Tarefa(
                titulo,
                false,
                LocalDate.now().plusDays(1),
                "Sem descrição",
                "MÉDIA"
        );

        return salvar(tarefa);
    }

    public List<Tarefa> listarTodas() {
        System.out.println("[REPOSITORY] Buscando todas as tarefas em memória");
        return new ArrayList<>(banco.values());
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        System.out.println("[REPOSITORY] Buscando tarefa por id: " + id);
        return Optional.ofNullable(banco.get(id));
    }

    public List<Tarefa> listarConcluidas() {
        System.out.println("[REPOSITORY] Buscando todas as tarefas concluídas");
        return banco.values().stream()
                .filter(Tarefa::isConcluida)
                .collect(Collectors.toList());
    }
}