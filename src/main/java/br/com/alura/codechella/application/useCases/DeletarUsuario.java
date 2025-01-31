package br.com.alura.codechella.application.useCases;

import br.com.alura.codechella.application.gateways.UsuarioRepository;

public class DeletarUsuario{

    private final UsuarioRepository usuarioRepository;

    public DeletarUsuario(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deletarUsuario(id);
    }
}
