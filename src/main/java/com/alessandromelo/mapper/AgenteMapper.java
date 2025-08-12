package com.alessandromelo.mapper;

import com.alessandromelo.dto.agente.AgenteRequestDTO;
import com.alessandromelo.dto.agente.AgenteResponseDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResumoResponseDTO;
import com.alessandromelo.entity.Agente;

public class AgenteMapper {


    //RequestDTO -> Entity
    public Agente toEntity(AgenteRequestDTO agenteRequestDTO){

        Agente agente = new Agente();
        agente.setVersao(agenteRequestDTO.getVersao());
        agente.setStatus(agenteRequestDTO.getStatus());
        agente.setLog(agenteRequestDTO.getLog());
        agente.setDataUltimaAtividade(agenteRequestDTO.getDataUltimaAtividade());

        return agente;
    }


    //Entity -> ResponseDTO
    public AgenteResponseDTO toResponseDTO(Agente agente){

        AgenteResponseDTO agenteResponseDTO = new AgenteResponseDTO();
        agenteResponseDTO.setId(agente.getId());
        agenteResponseDTO.setVersao(agente.getVersao());
        agenteResponseDTO.setStatus(agente.getStatus());
        agenteResponseDTO.setLog(agente.getLog());
        agenteResponseDTO.setDataUltimaAtividade(agente.getDataUltimaAtividade());

        if(agente.getDispositivo() != null){

            DispositivoResumoResponseDTO dispositivoResumoResponseDTO = new DispositivoResumoResponseDTO();
            dispositivoResumoResponseDTO.setId(agente.getDispositivo().getId());
            dispositivoResumoResponseDTO.setModelo(agente.getDispositivo().getModelo());
            dispositivoResumoResponseDTO.setStatus(agente.getDispositivo().getStatus());

            agenteResponseDTO.setDispositivoResumoResponseDTO(dispositivoResumoResponseDTO);

        }
        return agenteResponseDTO;
    }

}
