package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.RepositoryUsuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import java.util.List;
import java.util.NoSuchElementException;

public class RepositorioDeUsuarioJpa implements UsuarioRepository{


    private final RepositoryUsuario repositoryUsuario;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(RepositoryUsuario repositoryUsuario, UsuarioEntityMapper mapper) {
        this.repositoryUsuario = repositoryUsuario;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repositoryUsuario.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos(){
        List<UsuarioEntity> listaDeUsuarios = repositoryUsuario.findAll();
        return listaDeUsuarios.stream().map(x -> mapper.toDomain(x)).toList();
    }

    @Override
    public void deletarUsuario(Long id){
        UsuarioEntity usuario = repositoryUsuario.getReferenceById(id);
        if(usuario != null){
            repositoryUsuario.deleteById(id);
        } else {
            throw new NoSuchElementException("Resource not found" + usuario.getId());
        }
    }

    @Override
    public Usuario atualizarUsuario(Long id, UsuarioEntity entity) {
            entity.setId(id);
            repositoryUsuario.save(entity);
            return mapper.toDomain(entity);
        }
}
