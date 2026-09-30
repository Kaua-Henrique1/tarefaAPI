package br.edu.ifrn.tarefa.repository;

import br.edu.ifrn.tarefa.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryInterface {
    public Usuario salvar(Usuario usuario);
    public List<Usuario> listarTodas();
    public Optional<Usuario> buscarPorId(Long id);
    public Optional<Usuario> atualizar(Long id, Usuario usuarioNovo);
    public Optional<Usuario> deletar(Long id);
}
