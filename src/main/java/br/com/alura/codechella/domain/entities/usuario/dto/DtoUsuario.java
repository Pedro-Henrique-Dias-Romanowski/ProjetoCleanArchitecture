package br.com.alura.codechella.domain.entities.usuario.dto;

import java.time.LocalDate;

public record DtoUsuario(String cpf, String nome, LocalDate nascimento, String email) {
}
