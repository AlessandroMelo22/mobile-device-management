package com.alessandromelo.mapper;

import com.alessandromelo.dto.comando.ComandoRequestDTO;
import com.alessandromelo.dto.comando.ComandoResponseDTO;
import com.alessandromelo.dto.comando.ComandoResumoResponseDTO;
import com.alessandromelo.entity.Comando;
import com.alessandromelo.enums.ComandoStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ComandoMapper {


    public Comando toEntity(ComandoRequestDTO comandoRequestDTO){

        Comando comando = new Comando();

        comando.setTipo(comandoRequestDTO.getTipo());
        comando.setStatus(ComandoStatus.PENDENTE); //Um novo comando sempre irá iniciar como "PENDENTE"
        comando.setParametros(comandoRequestDTO.getParametros());
        comando.setDataCriacao(LocalDateTime.now()); // setta a data  hora atual de criação

        return comando;
    }

    public ComandoResponseDTO toResponseDTO(Comando comando){

        ComandoResponseDTO comandoResponseDTO = new ComandoResponseDTO();

        comandoResponseDTO.setId(comando.getId());
        comandoResponseDTO.setTipo(comando.getTipo());
        comandoResponseDTO.setStatus(comando.getStatus());
        comandoResponseDTO.setParametros(comando.getParametros());
        comandoResponseDTO.setDataCriacao(comando.getDataCriacao());
        comandoResponseDTO.setDataExecucao(comando.getDataExecucao());

        comandoResponseDTO.setAgenteId(comando.getAgente().getId()); //mostra apenas o ID do agente

        return comandoResponseDTO;
    }


    public ComandoResumoResponseDTO toResumoResponseDTO(Comando comando){

        ComandoResumoResponseDTO comandoResumoResponseDTO = new ComandoResumoResponseDTO();

        comandoResumoResponseDTO.setId(comando.getId());
        comandoResumoResponseDTO.setTipo(comando.getTipo());
        comandoResumoResponseDTO.setStatus(comando.getStatus());
        comandoResumoResponseDTO.setDataCriacao(comando.getDataCriacao());

        return comandoResumoResponseDTO;
    }
}
