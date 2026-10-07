package br.edu.ifrn.tarefa.repository;

import br.edu.ifrn.tarefa.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}