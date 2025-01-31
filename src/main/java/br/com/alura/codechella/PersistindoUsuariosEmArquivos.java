package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.io.IOException;
import java.time.LocalDate;

public class PersistindoUsuariosEmArquivos{
    public static void main(String[] args) throws IOException {
        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();

        repositorio.cadastarUsuario(new Usuario("109.303.269-38", "Pedro", LocalDate.parse("2005-11-12"),
                "pedro@gmail.com"));

        repositorio.cadastarUsuario(new Usuario("222.322.211-12", "João", LocalDate.parse("2000-09-11"),
                "joao@gmail.com"));

        repositorio.cadastarUsuario(new Usuario("111.324.123-32", "Matheus", LocalDate.parse("2002-12-10"),
                "matheus@gmail.com"));

        repositorio.cadastarUsuario(new Usuario("100.300.261-28", "Gabriel", LocalDate.parse("2003-08-14"),
                "gabriel@gmail.com"));

        System.out.println(repositorio.listarTodos());
    }
}
