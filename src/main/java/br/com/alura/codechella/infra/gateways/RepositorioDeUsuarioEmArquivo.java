package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUsuarioEmArquivo implements UsuarioRepository{

    List<Usuario> usuarios = new ArrayList<>();

     BufferedWriter writer = new BufferedWriter(new FileWriter("arquivosUsuarios.txt"));

    public RepositorioDeUsuarioEmArquivo() throws IOException {
    }

    @Override
    public Usuario cadastarUsuario(Usuario usuario) throws IOException {
        usuarios.add(usuario);
        try{
            writer.write(usuario.toString());
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }


    @Override
    public void deletarUsuario(Long id) {

    }

    @Override
    public Usuario atualizarUsuario(Long id, UsuarioEntity entity) {
        return null;
    }
}
