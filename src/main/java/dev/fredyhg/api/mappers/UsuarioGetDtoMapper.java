package dev.fredyhg.api.mappers;

import dev.fredyhg.api.models.Usuario;
import dev.fredyhg.api.requests.UsuarioGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsuarioGetDtoMapper {

    UsuarioGetDtoMapper INSTANCE = Mappers.getMapper(UsuarioGetDtoMapper.class);

    UsuarioGetDTO toDTO(Usuario usuario);

    @Mapping(target = "id", source = "usuario.id")
    @Mapping(target = "nome", source = "usuario.nome")
    List<UsuarioGetDTO> toDTOPage(List<Usuario> usuarios);

}
