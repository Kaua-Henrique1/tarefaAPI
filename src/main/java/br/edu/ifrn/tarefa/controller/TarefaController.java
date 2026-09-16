package br.edu.ifrn.tarefa.controller;

import br.edu.ifrn.tarefa.dto.TarefaRequestDto;
import br.edu.ifrn.tarefa.dto.TarefaResponseDto;
import br.edu.ifrn.tarefa.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDto> criar(@RequestBody TarefaRequestDto dto) {
        System.out.println("[CONTROLLER] Requisição recebida: POST /tarefas");

        TarefaResponseDto criada = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listar() {
        System.out.println("[CONTROLLER] Requisição recebida: GET /tarefas");
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDto> buscar(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: GET /tarefas/" + id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/concluidas")
    public ResponseEntity<List<TarefaResponseDto>> concluidas() {
        System.out.println("[CONTROLLER] Requisição recebida: GET /tarefas/concluidas");
        return ResponseEntity.ok(service.listarConcluidos());
    }
}