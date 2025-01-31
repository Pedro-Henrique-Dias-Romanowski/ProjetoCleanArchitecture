package br.com.alura.codechella.infra.controller;


import br.com.alura.codechella.application.useCases.AtualizarUsuario;
import br.com.alura.codechella.application.useCases.CriarUsuario;
import br.com.alura.codechella.application.useCases.DeletarUsuario;
import br.com.alura.codechella.application.useCases.ListarUsuario;
import br.com.alura.codechella.domain.entities.usuario.dto.DtoListagemUsuario;
import br.com.alura.codechella.domain.entities.usuario.dto.DtoUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    private final CriarUsuario criarUsuario;

    private final ListarUsuario listarUsuario;

    private final DeletarUsuario deletarUsuario;

    private final AtualizarUsuario atualizarUsuario;

    public  UsuarioController(CriarUsuario criarUsuario, ListarUsuario listarUsuario,
                              DeletarUsuario deletarUsuario, AtualizarUsuario atualizarUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuario = listarUsuario;
        this.deletarUsuario = deletarUsuario;
        this.atualizarUsuario = atualizarUsuario;
    }

    @PostMapping("/cadastrar")
    public DtoUsuario cadastrar(@RequestBody DtoUsuario dtoUsuario) throws IOException {
        Usuario usuarioSalvo = criarUsuario.cadastrarUsuario(new Usuario(dtoUsuario.cpf(),dtoUsuario.nome() ,dtoUsuario.nascimento(), dtoUsuario.email()));
        return new DtoUsuario(usuarioSalvo.getCpf(), usuarioSalvo.getNome(), usuarioSalvo.getNascimento(), usuarioSalvo.getEmail());
    }

    @GetMapping("/findAll")
    public List<DtoListagemUsuario> listar(){
        List<Usuario> listaDeUsuarios = listarUsuario.listarTodos();
        return listaDeUsuarios.stream().map( x-> new DtoListagemUsuario(x)).toList();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id){
        deletarUsuario.deletarUsuario(id);
    }

    @PutMapping("/{id}")
    public void atualizarUsuario(@PathVariable Long id, @RequestBody DtoUsuario dtoUsuario){
        atualizarUsuario.atualizarUsuario(id, new UsuarioEntity(dtoUsuario));
    }
}
