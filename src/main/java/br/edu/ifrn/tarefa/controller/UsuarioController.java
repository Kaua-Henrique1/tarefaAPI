package br.edu.ifrn.tarefa.controller;

import br.edu.ifrn.tarefa.dto.UsuarioRequestDTO;
import br.edu.ifrn.tarefa.dto.UsuarioResponseDTO;
import br.edu.ifrn.tarefa.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody UsuarioRequestDTO dto) {
        System.out.println("[CONTROLLER] Requisição recebida: POST /usuarios");

        UsuarioResponseDTO criada = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }


    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        System.out.println("[CONTROLLER] Requisição recebida: GET /usuarios");
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: GET /usuarios/" + id);
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto) {
        System.out.println("[CONTROLLER] Requisição recebida: PUT /usuarios/" + id);
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> deletar(@PathVariable Long id) {
        System.out.println("[CONTROLLER] Requisição recebida: DELETE /usuarios/" + id);
        return ResponseEntity.ok(service.deletar(id));
    }
}
