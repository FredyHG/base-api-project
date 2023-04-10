package dev.fredyhg.api.utils;

import dev.fredyhg.api.models.Usuario;
import dev.fredyhg.api.requests.UsuarioGetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListToPageable {

    public static Page<UsuarioGetDTO> usuarioListToPage(List<UsuarioGetDTO> listUsuario){
        return new PageImpl<>(listUsuario);
    }

}
