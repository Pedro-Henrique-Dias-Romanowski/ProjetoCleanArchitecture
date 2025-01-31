package br.com.alura.codechella.application.useCases;

import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuario{

    private final UsuarioRepository usuarioRepository;

    public ListarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos(){
        return this.usuarioRepository.listarTodos();
    }

}
