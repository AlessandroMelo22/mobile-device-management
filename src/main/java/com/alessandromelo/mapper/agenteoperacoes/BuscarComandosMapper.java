package com.alessandromelo.mapper.agenteoperacoes;

import com.alessandromelo.dto.agenteoperacoes.buscarcomandospendentes.BuscarComandosPendentesResponseDTO;
import com.alessandromelo.dto.comando.ComandoResumoResponseDTO;
import com.alessandromelo.entity.Comando;
import com.alessandromelo.mapper.ComandoMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarComandosMapper {

    private ComandoMapper comandoMapper;

    BuscarComandosMapper() {
    }

    public BuscarComandosMapper(ComandoMapper comandoMapper) {
        this.comandoMapper = comandoMapper;
    }



    //toResponseDTO
    public BuscarComandosPendentesResponseDTO toResponseDTO(Long agenteId, List<Comando> comandos){

        List<ComandoResumoResponseDTO> comandosResumoDTO = comandos.stream()
                .map(comando -> this.comandoMapper.toResumoResponseDTO(comando))
                .toList();

        return new BuscarComandosPendentesResponseDTO(agenteId, comandosResumoDTO);
    }
}
