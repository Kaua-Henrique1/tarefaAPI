package br.edu.ifrn.tarefa.service;

import br.edu.ifrn.tarefa.dto.TarefaRequestDto;
import br.edu.ifrn.tarefa.dto.TarefaResponseDto;
import br.edu.ifrn.tarefa.model.Tarefa;
import br.edu.ifrn.tarefa.repository.TarefaRepository;
import br.edu.ifrn.tarefa.strategy.LowPriorityStrategy;
import br.edu.ifrn.tarefa.strategy.NormalPriorityStrategy;
import br.edu.ifrn.tarefa.strategy.PriorityStrategy;
import br.edu.ifrn.tarefa.strategy.UrgentPriorityStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public TarefaResponseDto criar(TarefaRequestDto dto) {
        Tarefa tarefa = new Tarefa(
                dto.titulo(),
                false,
                dto.prazo(),
                dto.descricao(),
                "NORMAL"
        );

        Tarefa salva = repository.salvar(tarefa);
        return toResponseDto(salva);
    }

    public List<TarefaResponseDto> listarTodas() {
        return repository.listarTodas().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public TarefaResponseDto buscarPorId(Long id) {
        Tarefa tarefa = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return toResponseDto(tarefa);
    }

    public List<TarefaResponseDto> listarConcluidos() {
        return repository.listarConcluidas().stream()
                .map(this::toResponseDto)
                .toList();
    }

    private TarefaResponseDto toResponseDto(Tarefa tarefa) {
        return new TarefaResponseDto(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.isConcluida(),
                tarefa.getPrioridade()
        );
    }

    private PriorityStrategy escolherEstrategia(LocalDate prazo) {
        if (prazo == null) {
            return new LowPriorityStrategy();
        }
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), prazo);
        if (dias <= 1) {
            return new UrgentPriorityStrategy();
        } else if (dias <= 7) {
            return new NormalPriorityStrategy();
        }
        return new LowPriorityStrategy();
    }
}