package com.alessandromelo.mapper;

import com.alessandromelo.dto.dispositivo.DispositivoRequestDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResponseDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResumoDTO;
import com.alessandromelo.dto.usuario.UsuarioResumoDTO;
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

        UsuarioResumoDTO usuarioResumoDTO = new UsuarioResumoDTO();

        usuarioResumoDTO.setId(dispositivo.getUsuario().getId());
        usuarioResumoDTO.setNome(dispositivo.getUsuario().getNome());

        dispositivoResponseDTO.setUsuarioResumoDTO(usuarioResumoDTO);

        return dispositivoResponseDTO;
    }

    public DispositivoResumoDTO toResumoDTO(Dispositivo dispositivo){

        DispositivoResumoDTO dispositivoResumoDTO = new DispositivoResumoDTO();

        dispositivoResumoDTO.setId(dispositivo.getId());
        dispositivoResumoDTO.setModelo(dispositivo.getModelo());

        return dispositivoResumoDTO;
    }

}
