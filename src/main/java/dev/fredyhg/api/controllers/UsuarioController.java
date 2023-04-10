package dev.fredyhg.api.controllers;

import dev.fredyhg.api.mappers.UsuarioGetDtoMapper;

import dev.fredyhg.api.models.Usuario;
import dev.fredyhg.api.requests.UsuarioGetDTO;
import dev.fredyhg.api.services.UsuarioService;
import dev.fredyhg.api.utils.ListToPageable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/usuario/")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("list")
    public ResponseEntity<Page<UsuarioGetDTO>> findUsuario(Pageable pageable){

        List<UsuarioGetDTO> usuarioGetDTO = UsuarioGetDtoMapper.INSTANCE.toDTOPage(usuarioService.listAll(pageable).stream().toList());

        return ResponseEntity.status(HttpStatus.OK).body(ListToPageable.usuarioListToPage(usuarioGetDTO));
    }


}
