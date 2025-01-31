package br.com.alura.codechella.application.useCases;

import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

public class AtualizarUsuario{

    private final UsuarioRepository usuarioRepository;

    public AtualizarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario atualizarUsuario(Long id, UsuarioEntity entity){
        return usuarioRepository.atualizarUsuario(id, entity);
    }
}
