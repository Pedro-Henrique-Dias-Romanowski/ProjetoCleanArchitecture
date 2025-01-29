package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface UsuarioRepository{

    Usuario cadastarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

}
