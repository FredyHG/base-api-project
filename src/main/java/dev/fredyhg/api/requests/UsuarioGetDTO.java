package dev.fredyhg.api.requests;

import lombok.Data;

import java.util.UUID;

@Data
public class UsuarioGetDTO {

    private UUID id;

    private String nome;

    private String sobrenome;

}
