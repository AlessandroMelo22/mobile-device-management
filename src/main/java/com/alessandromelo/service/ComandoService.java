package com.alessandromelo.service;

import com.alessandromelo.dto.comando.ComandoRequestDTO;
import com.alessandromelo.dto.comando.ComandoResponseDTO;
import com.alessandromelo.entity.Comando;
import com.alessandromelo.enums.ComandoStatus;
import com.alessandromelo.exception.comando.ComandoNaoEncontradoException;
import com.alessandromelo.mapper.ComandoMapper;
import com.alessandromelo.repository.ComandoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandoService {

    private ComandoRepository comandoRepository;
    private ComandoMapper comandoMapper;



    public ComandoService(ComandoRepository comandoRepository, ComandoMapper comandoMapper) {
        this.comandoRepository = comandoRepository;
        this.comandoMapper = comandoMapper;
    }



    public List<ComandoResponseDTO> buscarTodosComandos(){

        List<Comando> comandos = this.comandoRepository.findAll();
        return comandos.stream().map(this.comandoMapper::toResponseDTO).toList();
    }

    public List<ComandoResponseDTO> buscarComandosPorStatus(ComandoStatus status){

        List<Comando> comandos = this.comandoRepository.findByStatus(status);
        return comandos.stream().map(this.comandoMapper::toResponseDTO).toList();
    }

    public ComandoResponseDTO buscarComandoPorId(Long comandoId){

        Comando comando = this.comandoRepository.findById(comandoId)
                .orElseThrow(() -> new ComandoNaoEncontradoException(comandoId));

        return this.comandoMapper.toResponseDTO(comando);
    }

    public ComandoResponseDTO criarComando(ComandoRequestDTO novoComandoDTO){

        Comando comando = this.comandoMapper.toEntity(novoComandoDTO);
        return this.comandoMapper.toResponseDTO(this.comandoRepository.save(comando));
    }
}
