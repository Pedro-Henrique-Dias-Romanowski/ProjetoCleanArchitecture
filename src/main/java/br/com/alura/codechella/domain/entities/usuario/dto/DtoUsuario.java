package br.com.alura.codechella.domain.entities.usuario.dto;

import br.com.alura.codechella.infra.persistence.UsuarioEntity;

import java.time.LocalDate;

public record DtoUsuario(String cpf, String nome, LocalDate nascimento, String email){
    public DtoUsuario(UsuarioEntity entity){
        this(entity.getCpf(), entity.getNome(), entity.getNascimento(), entity.getEmail());
    }
}
