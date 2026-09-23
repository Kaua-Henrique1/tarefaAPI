package br.edu.ifrn.tarefa.repository;

import br.edu.ifrn.tarefa.model.Tarefa;
import br.edu.ifrn.tarefa.model.Usuario;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UsuarioRepository {

    private final Map<Long, Usuario> banco = new LinkedHashMap<>();
    private final AtomicLong sequencia = new AtomicLong();

    public Usuario salvar(Usuario usuario) {
        System.out.println("[REPOSITORY] Salvando usuario em memória: " + usuario.getNome());
        Long id = sequencia.incrementAndGet();
        usuario.setId(id);
        banco.put(id, usuario);
        return usuario;
    }

    public Usuario salvar(String nome, String cargo, String email) {
        Usuario usuario = new Usuario(
                nome,
                email,
                cargo
        );

        return salvar(usuario);
    }

    public List<Usuario> listarTodas() {
        System.out.println("[REPOSITORY] Buscando todas as usuarios em memória");
        return new ArrayList<>(banco.values());
    }

    public Optional<Usuario> buscarPorId(Long id) {
        System.out.println("[REPOSITORY] Buscando usuario por id: " + id);
        return Optional.ofNullable(banco.get(id));
    }

    public Optional<Usuario> atualizar(Long id, Usuario usuarioNovo) {
        System.out.println("[REPOSITORY] Atualizando usuario em memória com esse id: " + id);
        banco.put(id, usuarioNovo);
        return Optional.ofNullable(banco.get(id));
    }

    public Optional<Usuario> deletar(Long id) {
        System.out.println("[REPOSITORY] Deletando usuario em memória com esse id: " + id);
        banco.remove(id);
        return Optional.ofNullable(banco.get(id));
    }
}
