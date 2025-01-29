package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.entities.usuario.BuilderOfUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {


    @Test
    public void naoDeveCadastrarUmUsuarioComCpfInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Pedro", LocalDate.parse("2005-12-11"), "pedro@gmail"));

    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){
        BuilderOfUsuario builder = new BuilderOfUsuario();
        Usuario usuario =  builder.comNomeCpfNascimento("Pedro", "109.303.269-38",
                LocalDate.parse("2005-12-11"));

        Assertions.assertEquals("Pedro", usuario.getNome());

        usuario = builder.incluiEndereco("81240-280", 246, "Complemento aleatório");

        Assertions.assertEquals("Complemento aleatório", usuario.getEndereco().getComplemento() );
    }


    @Test
    public void naoDeveCriarUmUsuarioMenorDeIdade(){


        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("109.303.269-38", "Pedro", LocalDate.parse("2000-10-10"), "pedro@gmail"));

        Assertions.assertEquals("Data de nascimento inválida", exception.getMessage());
    }


}
