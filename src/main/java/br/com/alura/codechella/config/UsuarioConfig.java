package br.com.alura.codechella.config;


import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.application.useCases.AtualizarUsuario;
import br.com.alura.codechella.application.useCases.CriarUsuario;
import br.com.alura.codechella.application.useCases.DeletarUsuario;
import br.com.alura.codechella.application.useCases.ListarUsuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.RepositoryUsuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(UsuarioRepository usuarioRepository) {
        return new CriarUsuario(usuarioRepository);
    }

    @Bean
    RepositorioDeUsuarioJpa criarRepositorioDeUsuarioJpa(RepositoryUsuario repositoryUsuario, UsuarioEntityMapper mapper) {
        return new RepositorioDeUsuarioJpa(repositoryUsuario, mapper);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }

    @Bean
    ListarUsuario listarUsuario(UsuarioRepository usuarioRepository){
        return new ListarUsuario(usuarioRepository);
    }

    @Bean
    DeletarUsuario deletarUsuario(UsuarioRepository usuarioRepository){
        return new DeletarUsuario(usuarioRepository);
    }

    @Bean
    AtualizarUsuario atualizarUsuario(UsuarioRepository usuarioRepository){
        return new AtualizarUsuario(usuarioRepository);
    }
}
