package com.alessandromelo.service;

import com.alessandromelo.dto.agente.AgenteRequestDTO;
import com.alessandromelo.dto.agente.AgenteResponseDTO;
import com.alessandromelo.entity.Agente;
import com.alessandromelo.exception.agente.AgenteNaoEncontradoException;
import com.alessandromelo.mapper.AgenteMapper;
import com.alessandromelo.repository.AgenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteService {

    private AgenteRepository agenteRepository;
    private AgenteMapper agenteMapper;

    public AgenteService(AgenteRepository agenteRepository, AgenteMapper agenteMapper) {
        this.agenteRepository = agenteRepository;
        this.agenteMapper = agenteMapper;
    }

    public List<AgenteResponseDTO> listarTodosAgentes() {

        List<Agente> agentes = this.agenteRepository.findAll();
        return agentes.stream().map(agenteMapper::toResponseDTO).toList();
    }


    public AgenteResponseDTO buscarAgentePorId(Long agenteId){

        Agente agente = this.agenteRepository.findById(agenteId)
                .orElseThrow(() -> new AgenteNaoEncontradoException(agenteId));

        return this.agenteMapper.toResponseDTO(agente);
    }

    public AgenteResponseDTO cadastrarNovoAgente(AgenteRequestDTO novoAgenteDTO) {



        return null;
    }

}
