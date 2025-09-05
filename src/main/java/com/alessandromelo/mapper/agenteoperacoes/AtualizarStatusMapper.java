package com.alessandromelo.mapper.agenteoperacoes;

import com.alessandromelo.dto.agenteoperacoes.atualizarstatus.AtualizarStatusResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AtualizarStatusMapper {

    public AtualizarStatusResponseDTO toResponseDTO(Long agenteId){
        return new AtualizarStatusResponseDTO(agenteId);
    }

}
