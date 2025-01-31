package br.com.alura.codechella.application.useCases;

import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.io.IOException;


public class CriarUsuario{

    private final UsuarioRepository repository;

    public CriarUsuario(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) throws IOException {
        return repository.cadastarUsuario(usuario);
    }
}
