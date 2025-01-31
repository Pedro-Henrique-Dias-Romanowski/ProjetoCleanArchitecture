package br.com.alura.codechella.domain.entities.usuario.dto;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.time.LocalDate;

public record DtoListagemUsuario(String cpf, String nome, LocalDate nascimento, String email){

    public DtoListagemUsuario(Usuario usuario){
        this(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail());
    }
}
