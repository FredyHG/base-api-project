package dev.fredyhg.api.services;

import dev.fredyhg.api.models.Usuario;
import dev.fredyhg.api.repositories.UsuarioRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Page<Usuario> listAll(Pageable pageable) {

        return usuarioRepository.findAll(pageable);

    }


}
