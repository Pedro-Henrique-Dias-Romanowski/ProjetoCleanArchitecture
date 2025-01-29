package br.com.alura.codechella.application.useCases;

import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CriarUsuario{

    private final UsuarioRepository repository;

    @Autowired
    public CriarUsuario(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        return repository.cadastarUsuario(usuario);
    }
}
