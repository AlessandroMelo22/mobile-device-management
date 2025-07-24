package com.alessandromelo.mapper;

import com.alessandromelo.dto.dispositivo.DispositivoRequestDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResponseDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResumoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioResumoResponseDTO;
import com.alessandromelo.enums.DispositivoStatus;
import com.alessandromelo.entity.Dispositivo;
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

        if(dispositivoRequestDTO.getStatus() == null){ //Se o status não for informado sera setado por padrão como ATIVO
            dispositivo.setStatus(DispositivoStatus.ATIVO);
        } else {
            dispositivo.setStatus(dispositivoRequestDTO.getStatus());
        }

        dispositivo.setDataAquisicao(dispositivoRequestDTO.getDataAquisicao());
        dispositivo.setDataUltimaAtualizacao(dispositivoRequestDTO.getDataUltimaAtualizacao());
        dispositivo.setObservacoes(dispositivoRequestDTO.getObservacoes());

        return dispositivo;
    }

    //Entity -> responseDTO
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

        if(dispositivo.getUsuario() != null){

            UsuarioResumoResponseDTO usuarioResumoResponseDTO = new UsuarioResumoResponseDTO();
            usuarioResumoResponseDTO.setId(dispositivo.getUsuario().getId());
            usuarioResumoResponseDTO.setNome(dispositivo.getUsuario().getNome());
            usuarioResumoResponseDTO.setMatricula(dispositivo.getUsuario().getMatricula());

            dispositivoResponseDTO.setUsuarioResumoResponseDTO(usuarioResumoResponseDTO);
        }

        return dispositivoResponseDTO;
    }

    //Entity -> resumoResponseDTO:
    public DispositivoResumoResponseDTO toResumoResponseDTO(Dispositivo dispositivo){

        DispositivoResumoResponseDTO dispositivoResumoResponseDTO = new DispositivoResumoResponseDTO();

        dispositivoResumoResponseDTO.setId(dispositivo.getId());
        dispositivoResumoResponseDTO.setModelo(dispositivo.getModelo());
        dispositivoResumoResponseDTO.setStatus(dispositivo.getStatus());

        return dispositivoResumoResponseDTO;
    }

}
