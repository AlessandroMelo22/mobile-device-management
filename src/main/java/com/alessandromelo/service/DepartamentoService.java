package com.alessandromelo.service;

import com.alessandromelo.dto.departamento.DepartamentoRequestDTO;
import com.alessandromelo.dto.departamento.DepartamentoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioResumoResponseDTO;
import com.alessandromelo.exception.departamento.DepartamentoNaoEncontradoException;
import com.alessandromelo.exception.departamento.NomeJaCadastradoException;
import com.alessandromelo.exception.departamento.SiglaJaCadastradaException;
import com.alessandromelo.mapper.DepartamentoMapper;
import com.alessandromelo.mapper.UsuarioMapper;
import com.alessandromelo.entity.Departamento;
import com.alessandromelo.entity.Usuario;
import com.alessandromelo.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private DepartamentoRepository departamentoRepository;
    private DepartamentoMapper departamentoMapper;

    private UsuarioMapper usuarioMapper;

    public DepartamentoService(DepartamentoRepository departamentoRepository, DepartamentoMapper departamentoMapper, UsuarioMapper usuarioMapper) {
        this.departamentoRepository = departamentoRepository;
        this.departamentoMapper = departamentoMapper;
        this.usuarioMapper = usuarioMapper;
    }

    //Listar Departamentos:
    public List<DepartamentoResponseDTO> listarTodosDepartamentos(){

        List<Departamento> departamentos = this.departamentoRepository.findAll();

        return departamentos.stream().map(this.departamentoMapper::toResponseDTO).toList();
    }

    //Buscar Departamento por Id:
    public DepartamentoResponseDTO buscarDepartamentoPorId(Long departamentoId){

        Departamento departamento = this.departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new DepartamentoNaoEncontradoException(departamentoId));

        return this.departamentoMapper.toResponseDTO(departamento);
    }

    //Criar Departamento: (CERTO)
    public DepartamentoResponseDTO criarNovoDepartamento(DepartamentoRequestDTO novoDepartamentoDTO){

        Boolean nomeJaExiste = this.departamentoRepository.existsByNome(novoDepartamentoDTO.getNome());
        Boolean siglaJaExiste = this.departamentoRepository.existsBySigla(novoDepartamentoDTO.getSigla());

        if(nomeJaExiste){
            throw new NomeJaCadastradoException();
        } else if (siglaJaExiste) {
            throw new SiglaJaCadastradaException();
        }

        Departamento departamento = this.departamentoMapper.toEntity(novoDepartamentoDTO);

        return this.departamentoMapper.toResponseDTO(this.departamentoRepository.save(departamento));
    }

    //Atualizar Departamento: (CONSERTAR O PROBLEMA DE CAMPOS NULOS)
    public DepartamentoResponseDTO atualizarDepartamento(Long departamentoId, DepartamentoRequestDTO departamentoAtualizadoDTO){

        return this.departamentoRepository.findById(departamentoId)
                .map(departamento -> {

                    boolean nomeJaExiste = this.departamentoRepository.existsByNomeAndIdNot(departamentoAtualizadoDTO.getNome(), departamentoId);
                    boolean siglaJaExiste = this.departamentoRepository.existsBySiglaAndIdNot(departamentoAtualizadoDTO.getSigla(), departamentoId);

                    if (nomeJaExiste){
                        throw new NomeJaCadastradoException();
                    } else if (siglaJaExiste) {
                        throw new SiglaJaCadastradaException();
                    }

                    departamento.setNome(departamentoAtualizadoDTO.getNome());
                    departamento.setSigla(departamentoAtualizadoDTO.getSigla());

                    return this.departamentoMapper.toResponseDTO(this.departamentoRepository.save(departamento));

                }).orElseThrow(() -> new DepartamentoNaoEncontradoException(departamentoId));
    }

    //Remover Departamento: (CERTO)
    public void removerDepartamentoPorId(Long departamentoId){
        this.departamentoRepository.deleteById(departamentoId);
    }

    //Listar Usuarios que pertencem ao Departamento: (CERTO)
    public List<UsuarioResumoResponseDTO> listarUsuariosDoDepartamento(Long departamentoId){

        List<Usuario> usuarios = this.departamentoRepository.findById(departamentoId).map(Departamento::getUsuarios)
                .orElseThrow(() -> new DepartamentoNaoEncontradoException(departamentoId));

        return usuarios.stream().map(this.usuarioMapper::toResumoResponseDTO).toList();
    }

}
