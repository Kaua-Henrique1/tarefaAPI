package br.edu.ifrn.tarefa.service;

import br.edu.ifrn.tarefa.dto.TarefaRequestDto;
import br.edu.ifrn.tarefa.dto.TarefaResponseDto;
import br.edu.ifrn.tarefa.mapper.TarefaMapper;
import br.edu.ifrn.tarefa.model.Tarefa;
import br.edu.ifrn.tarefa.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository repository;
    private TarefaMapper tarefaMapper;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public TarefaResponseDto criar(TarefaRequestDto dto) {

        if (repository.equals(dto)) {
            throw new RuntimeException("Já existe um tarefa cadastrado com esses parâmetros " + dto.titulo());
        }

        Tarefa entidy = tarefaMapper.toEntity(dto);
        Tarefa salva = repository.save(entidy);
        return tarefaMapper.toDTO(salva);
    }

    public List<TarefaResponseDto> listarTodas() {

        return repository.findAll()
                .stream()
                .map(tarefaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TarefaResponseDto buscarPorId(Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrado com o ID:" + id));
        return tarefaMapper.toDTO(tarefa);
    }


    public TarefaResponseDto atualizar(Long id, TarefaRequestDto dto) {

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID do Tarefa não encontrada"));
        return tarefaMapper.toDTO(tarefa);
    }

    public TarefaResponseDto deletar(Long id) {
        Tarefa deleta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID do Tarefa não encontrada"));
        repository.delete(deleta);
        return tarefaMapper.toDTO(deleta);
    }
}