package com.alessandromelo.mapper;

import com.alessandromelo.dto.dispositivo.DispositivoRequestDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResponseDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResumoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioResumoResponseDTO;
import com.alessandromelo.model.Dispositivo;
import org.springframework.stereotype.Component;

@Component
public class DispositivoMapper {

    //RequestDTO -> Entity:
    public Dispositivo toEntity(DispositivoRequestDTO dispositivoRequestDTO){

        Dispositivo dispositivo = new Dispositivo();

        dispositivo.setModelo(dispositivoRequestDTO.getModelo());
        dispositivo.setMarca(dispositivoRequestDTO.getMarca());
        dispositivo.setNumeroSerie(dispositivoRequestDTO.getNumeroSerie());
        dispositivo.setSistemaOperacional(dispositivoRequestDTO.getSistemaOperacional());
        dispositivo.setVersaoSO(dispositivoRequestDTO.getVersaoSO());
        dispositivo.setStatus(dispositivoRequestDTO.getStatus());
        dispositivo.setDataAquisicao(dispositivoRequestDTO.getDataAquisicao());
        dispositivo.setDataUltimaAtualizacao(dispositivoRequestDTO.getDataUltimaAtualizacao());
        dispositivo.setObservacoes(dispositivoRequestDTO.getObservacoes());

        return dispositivo;
    }


    public DispositivoResponseDTO toResponseDTO(Dispositivo dispositivo){

        DispositivoResponseDTO dispositivoResponseDTO = new DispositivoResponseDTO();

        dispositivoResponseDTO.setId(dispositivo.getId());
        dispositivoResponseDTO.setModelo(dispositivo.getModelo());
        dispositivoResponseDTO.setMarca(dispositivo.getMarca());
        dispositivoResponseDTO.setNumeroSerie(dispositivo.getNumeroSerie());
        dispositivoResponseDTO.setSistemaOperacional(dispositivo.getSistemaOperacional());
        dispositivoResponseDTO.setVersaoSO(dispositivo.getVersaoSO());
        dispositivoResponseDTO.setStatus(dispositivo.getStatus());
        dispositivoResponseDTO.setDataAquisicao(dispositivo.getDataAquisicao());
        dispositivoResponseDTO.setDataUltimaAtualizacao(dispositivo.getDataUltimaAtualizacao());
        dispositivoResponseDTO.setObservacoes(dispositivo.getObservacoes());

        UsuarioResumoResponseDTO usuarioResumoResponseDTO = new UsuarioResumoResponseDTO();

        usuarioResumoResponseDTO.setId(dispositivo.getUsuario().getId());
        usuarioResumoResponseDTO.setNome(dispositivo.getUsuario().getNome());
        usuarioResumoResponseDTO.setMatricula(dispositivo.getUsuario().getMatricula());

        dispositivoResponseDTO.setUsuarioResumoDTO(usuarioResumoResponseDTO);

        return dispositivoResponseDTO;
    }

    public DispositivoResumoResponseDTO toResumoResponseDTO(Dispositivo dispositivo){

        DispositivoResumoResponseDTO dispositivoResumoResponseDTO = new DispositivoResumoResponseDTO();

        dispositivoResumoResponseDTO.setId(dispositivo.getId());
        dispositivoResumoResponseDTO.setModelo(dispositivo.getModelo());

        return dispositivoResumoResponseDTO;
    }

}
