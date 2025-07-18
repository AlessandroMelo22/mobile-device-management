package com.alessandromelo.service;

import com.alessandromelo.dto.dispositivo.DispositivoRequestDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResponseDTO;
import com.alessandromelo.exception.dispositivo.DispositivoNaoEncontradoException;
import com.alessandromelo.exception.dispositivo.NumeroDeSerieJaCadastradoException;
import com.alessandromelo.exception.usuario.UsuarioNaoEncontradoException;
import com.alessandromelo.mapper.DispositivoMapper;
import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.repository.DispositivoRepository;
import com.alessandromelo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    private DispositivoRepository dispositivoRepository;
    private DispositivoMapper dispositivoMapper;

    private UsuarioRepository usuarioRepository;

    public DispositivoService(DispositivoRepository dispositivoRepository, DispositivoMapper dispositivoMapper, UsuarioRepository usuarioRepository) {
        this.dispositivoRepository = dispositivoRepository;
        this.dispositivoMapper = dispositivoMapper;
        this.usuarioRepository = usuarioRepository;
    }

    //Listar todos os dispositivos: (CERTO)
    public List<DispositivoResponseDTO> listarTodosDispositivos(){

        List<Dispositivo> dispositivos = this.dispositivoRepository.findAll();
        return dispositivos.stream().map(dispositivoMapper::toResponseDTO).toList();
    }


    //Buscar Dispositivo por Id: (CERTO)
    public DispositivoResponseDTO buscarDispositivoPorId(Long dispositivoId){

        Dispositivo dispositivo = this.dispositivoRepository.findById(dispositivoId)
                .orElseThrow(() -> new DispositivoNaoEncontradoException(dispositivoId));

        return this.dispositivoMapper.toResponseDTO(dispositivo);
    }

    //Cadastrar Dispositivo: (CERTO)
    public DispositivoResponseDTO cadastrarNovoDispositivo(DispositivoRequestDTO novoDispositivoDTO){

        boolean numeroSerieExistente = this.dispositivoRepository.existsByNumeroSerie(novoDispositivoDTO.getNumeroSerie());

        if(numeroSerieExistente){
            throw new NumeroDeSerieJaCadastradoException();
        }

        Dispositivo dispositivo = this.dispositivoMapper.toEntity(novoDispositivoDTO);

        Usuario usuario = this.usuarioRepository.findById(novoDispositivoDTO.getUsuarioId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(novoDispositivoDTO.getUsuarioId()));

        dispositivo.setUsuario(usuario);

        return this.dispositivoMapper.toResponseDTO(this.dispositivoRepository.save(dispositivo));
    }

    //Atualizar Dispositivo: (CONSERTAR O PROBLEMA DE CAMPOS NULOS)
    public DispositivoResponseDTO atualizarDispositivo(Long dispositivoId, DispositivoRequestDTO dispositivoAtualizadoDTO){

       return this.dispositivoRepository.findById(dispositivoId)
               .map(dispositivo -> {

                   boolean numeroSerieExistente = this.dispositivoRepository.existsByNumeroSerieAndIdNot(dispositivoAtualizadoDTO.getNumeroSerie(), dispositivoId);

                   if (numeroSerieExistente){
                       throw new NumeroDeSerieJaCadastradoException();
                   }

                   dispositivo.setModelo(dispositivoAtualizadoDTO.getModelo());
                   dispositivo.setMarca(dispositivoAtualizadoDTO.getMarca());
                   dispositivo.setNumeroSerie(dispositivoAtualizadoDTO.getNumeroSerie());
                   dispositivo.setSistemaOperacional(dispositivoAtualizadoDTO.getSistemaOperacional());
                   dispositivo.setVersaoSO(dispositivoAtualizadoDTO.getVersaoSO());
                   dispositivo.setDataUltimaAtualizacao(dispositivoAtualizadoDTO.getDataUltimaAtualizacao());
                   dispositivo.setDataAquisicao(dispositivoAtualizadoDTO.getDataAquisicao());
                   dispositivo.setObservacoes(dispositivoAtualizadoDTO.getObservacoes());
                   dispositivo.setStatus(dispositivoAtualizadoDTO.getStatus());

                   Usuario usuario = this.usuarioRepository.findById(dispositivoAtualizadoDTO.getUsuarioId())
                           .orElseThrow(() -> new UsuarioNaoEncontradoException(dispositivoAtualizadoDTO.getUsuarioId()));

                   dispositivo.setUsuario(usuario);

                   return this.dispositivoMapper.toResponseDTO(this.dispositivoRepository.save(dispositivo));

               }).orElseThrow(() -> new DispositivoNaoEncontradoException(dispositivoId));
    }

    //Remover Dispositivo: (CERTO)
    public void removerDispositivoPorId(Long dispositivoId){
        this.dispositivoRepository.deleteById(dispositivoId);
    }



//Acho que não faz sentido um metodo de listar os Usuarios pois dentro da entidade ja possui a FK de Usuarios

//    //Buscar Usuario cadastrado em um determinado Dispositivo: (CERTO)
//    public Usuario buscarUsuarioCadastradoNoDispositivo(Long dispositivoId){
//        return this.dispositivoRepository.findById(dispositivoId)
//                .map(Dispositivo::getUsuario)
//                .orElseThrow(() -> new DispositivoNaoEncontradoException(dispositivoId));
//    }

}
