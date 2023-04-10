package dev.fredyhg.api.utils;

import dev.fredyhg.api.enums.Role;
import dev.fredyhg.api.models.Usuario;
import dev.fredyhg.api.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioPadrao implements ApplicationRunner {


    private final UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if(usuarioRepository.findByEmail("admin@admin.com").isPresent()){
            return;
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Usuario usuario = new Usuario();

        usuario.setEmail("admin@admin.com");
        usuario.setSenha(passwordEncoder.encode("admin"));
        usuario.setRole(Role.ROLE_ADMIN);

        usuarioRepository.save(usuario);

    }
}
