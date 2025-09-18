package com.alessandromelo.service;

import com.alessandromelo.dto.agente.AgenteRequestDTO;
import com.alessandromelo.dto.agente.AgenteResponseDTO;
import com.alessandromelo.entity.Agente;
import com.alessandromelo.entity.Dispositivo;
import com.alessandromelo.exception.agente.AgenteNaoEncontradoException;
import com.alessandromelo.exception.dispositivo.DispositivoNaoEncontradoException;
import com.alessandromelo.mapper.AgenteMapper;
import com.alessandromelo.repository.AgenteRepository;
import com.alessandromelo.repository.DispositivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteService {

    private AgenteRepository agenteRepository;
    private AgenteMapper agenteMapper;
    private DispositivoRepository dispositivoRepository;


    public AgenteService(AgenteRepository agenteRepository, AgenteMapper agenteMapper, DispositivoRepository dispositivoRepository) {
        this.agenteRepository = agenteRepository;
        this.agenteMapper = agenteMapper;
        this.dispositivoRepository = dispositivoRepository;
    }
//Buscar todos
    public List<AgenteResponseDTO> listarTodosAgentes() {

        List<Agente> agentes = this.agenteRepository.findAll();
        return agentes.stream().map(agenteMapper::toResponseDTO).toList();
    }

//Buscar por Id
    public AgenteResponseDTO buscarAgentePorId(Long agenteId){

        Agente agente = this.agenteRepository.findById(agenteId)
                .orElseThrow(() -> new AgenteNaoEncontradoException(agenteId));

        return this.agenteMapper.toResponseDTO(agente);
    }
//Cadastrar novo Agente
    public AgenteResponseDTO cadastrarNovoAgente(AgenteRequestDTO novoAgenteDTO) {

        Agente agente = this.agenteMapper.toEntity(novoAgenteDTO);

        if(novoAgenteDTO.getDispositivoId() != null){

            Dispositivo dispositivo = this.dispositivoRepository.findById(novoAgenteDTO.getDispositivoId())
                    .orElseThrow(() -> new DispositivoNaoEncontradoException(novoAgenteDTO.getDispositivoId()));

            agente.setDispositivo(dispositivo);
        }
        return this.agenteMapper.toResponseDTO(this.agenteRepository.save(agente));
    }

//Atualizar Agente:
    public AgenteResponseDTO atualizarAgente(Long agenteId, AgenteRequestDTO agenteAtualizadoDTO){

        return this.agenteRepository.findById(agenteId)
                .map(agente -> {

                    agente.setVersao(agenteAtualizadoDTO.getVersao());
                    agente.setStatus(agenteAtualizadoDTO.getStatus());
                    agente.setLog(agenteAtualizadoDTO.getLog());
                    agente.setDataUltimaAtividade(agenteAtualizadoDTO.getDataUltimaAtividade());

                    if(agenteAtualizadoDTO.getDispositivoId() != null){

                        Dispositivo dispositivo = this.dispositivoRepository.findById(agenteAtualizadoDTO.getDispositivoId())
                                .orElseThrow(() -> new DispositivoNaoEncontradoException(agenteAtualizadoDTO.getDispositivoId()));

                        agente.setDispositivo(dispositivo);
                    }
                    return this.agenteMapper.toResponseDTO(this.agenteRepository.save(agente));

                }).orElseThrow(() -> new AgenteNaoEncontradoException(agenteId));
    }

//Remover Agente: TEMPORARIO
    public void removerAgentePorId(Long agenteId){
        this.agenteRepository.deleteById(agenteId);
    }

}
