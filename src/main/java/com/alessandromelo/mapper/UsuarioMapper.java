package com.alessandromelo.mapper;

import com.alessandromelo.dto.departamento.DepartamentoResumoDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResumoDTO;
import com.alessandromelo.dto.usuario.UsuarioDepartamentoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioDispositivoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioRequestDTO;
import com.alessandromelo.dto.usuario.UsuarioResponseDTO;
import com.alessandromelo.model.Departamento;
import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    //ResquestDTO -> Entity:
    public Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO){

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setMatricula(usuarioRequestDTO.getMatricula());
        usuario.setCargo(usuarioRequestDTO.getCargo());
        usuario.setAtivo(usuarioRequestDTO.getAtivo());

        return usuario;
    }

    //Entity -> ResponseDTO:
    public UsuarioResponseDTO toResponseDTO(Usuario usuario){

        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
        usuarioResponseDTO.setId(usuario.getId());
        usuarioResponseDTO.setNome(usuario.getNome());
        usuarioResponseDTO.setEmail(usuario.getEmail());
        usuarioResponseDTO.setMatricula(usuario.getMatricula());
        usuarioResponseDTO.setCargo(usuario.getCargo());
        usuarioResponseDTO.setAtivo(usuario.getAtivo());

        //DepartamentoResumo:
        DepartamentoResumoDTO departamentoResumoDTO = new DepartamentoResumoDTO();
        departamentoResumoDTO.setId(usuario.getDepartamento().getId());
        departamentoResumoDTO.setNome(usuario.getDepartamento().getNome());

        usuarioResponseDTO.setDepartamentoResumoDTO(departamentoResumoDTO);

        return usuarioResponseDTO;
    }

    //Etity -> UsuarioDispositivoDTO:
    public UsuarioDispositivoResponseDTO toUsuarioDispositivoResponseDTO(Usuario usuario, Dispositivo dispositivo){

        UsuarioDispositivoResponseDTO usuarioDispositivoResponseDTO = new UsuarioDispositivoResponseDTO();
        usuarioDispositivoResponseDTO.setUsuarioId(usuario.getId());
        usuarioDispositivoResponseDTO.setNome(usuario.getNome());
        usuarioDispositivoResponseDTO.setMatricula(usuario.getMatricula());

        //DispositivoResumo:
        DispositivoResumoDTO dispositivoResumoDTO = new DispositivoResumoDTO();
        dispositivoResumoDTO.setId(dispositivo.getId());
        dispositivoResumoDTO.setModelo(dispositivo.getModelo());

        usuarioDispositivoResponseDTO.setDispositivoResumoDTO(dispositivoResumoDTO);

        return usuarioDispositivoResponseDTO;
    }

    //Entity
    public UsuarioDepartamentoResponseDTO toUsuarioDepartamentoResponseDTO(Usuario usuario, Departamento departamento){

        UsuarioDepartamentoResponseDTO usuarioDepartamentoResponseDTO = new UsuarioDepartamentoResponseDTO();
        usuarioDepartamentoResponseDTO.setUsuarioId(usuario.getId());
        usuarioDepartamentoResponseDTO.setNome(usuario.getNome());
        usuarioDepartamentoResponseDTO.setMatricula(usuario.getMatricula());

        //DepartamentoResumo:
        DepartamentoResumoDTO departamentoResumoDTO = new DepartamentoResumoDTO();
        departamentoResumoDTO.setId(departamento.getId());
        departamentoResumoDTO.setNome(departamento.getNome());

        usuarioDepartamentoResponseDTO.setDepartamentoResumoDTO(departamentoResumoDTO);

        return usuarioDepartamentoResponseDTO;
    }

}
