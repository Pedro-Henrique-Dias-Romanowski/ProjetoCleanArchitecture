package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

import java.io.IOException;
import java.util.List;



public interface UsuarioRepository{

    Usuario cadastarUsuario(Usuario usuario) throws IOException;

    List<Usuario> listarTodos();

    void deletarUsuario(Long id);

    Usuario atualizarUsuario(Long id, UsuarioEntity entity);

}
