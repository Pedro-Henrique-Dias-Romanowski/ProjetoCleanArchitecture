package br.com.alura.codechella.infra.controller;


import br.com.alura.codechella.application.useCases.CriarUsuario;
import br.com.alura.codechella.domain.entities.usuario.dto.DtoUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    private final CriarUsuario criarUsuario;

    public  UsuarioController(CriarUsuario criarUsuario) {
        this.criarUsuario = criarUsuario;
    }

    @PostMapping("/cadastrar")
    public DtoUsuario cadastrar(@RequestBody DtoUsuario dtoUsuario){
        Usuario usuarioSalvo = criarUsuario.cadastrarUsuario(new Usuario(dtoUsuario.cpf(),dtoUsuario.nome() ,dtoUsuario.nascimento(), dtoUsuario.email()));
        return new DtoUsuario(usuarioSalvo.getCpf(), usuarioSalvo.getNome(), usuarioSalvo.getNascimento(), usuarioSalvo.getEmail());
    }
}
