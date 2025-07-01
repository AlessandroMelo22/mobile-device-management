package com.alessandromelo.service;

import com.alessandromelo.model.Departamento;
import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.repository.DepartamentoRepository;
import com.alessandromelo.repository.DispositivoRepository;
import com.alessandromelo.repository.UsuarioRepository;
import com.alessandromelo.service.exception.departamento.DepartamentoNaoEncontradoException;
import com.alessandromelo.service.exception.dispositivo.DispositivoNaoEncontradoException;
import com.alessandromelo.service.exception.usuario.UsuarioNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private DepartamentoRepository departamentoRepository;
    private DispositivoRepository dispositivoRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, DepartamentoRepository departamentoRepository,
                          DispositivoRepository dispositivoRepository) {

        this.usuarioRepository = usuarioRepository;
        this.departamentoRepository = departamentoRepository;
        this.dispositivoRepository = dispositivoRepository;
    }

    //Listar todos os usuarios: (CERTO)
    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

//Buscar Usuario por id: (CERTO)
    public Optional<Usuario> buscarUsuarioPorId(Long usuarioId){
        return this.usuarioRepository.findById(usuarioId);
    }

//Cadastrar Usuario: (CERTO)
    public Usuario cadastrarNovoUsuario(Usuario novoUsuario){
        return this.usuarioRepository.save(novoUsuario);
    }

//Atualizar Usuario: (Está correto porem futuramente deve ser corrigido o problema dos possiveis campos nulos)
    public Optional<Usuario> atualizarUsuario(Long usuarioId, Usuario atualizado){

        return this.usuarioRepository.findById(usuarioId)
                .map(usuario -> {
                    usuario.setNome(atualizado.getNome());
                    usuario.setCargo(atualizado.getCargo());
                    usuario.setDepartamento(atualizado.getDepartamento());
                    usuario.setMatricula(atualizado.getMatricula());
                    usuario.setEmail(atualizado.getEmail());
                    usuario.setDispositivos(atualizado.getDispositivos());
                    usuario.setAtivo(atualizado.getAtivo());
                    return this.usuarioRepository.save(usuario);
                } );
    }

//Remover Usuario:
    public void removerUsuarioPorId(Long usuarioId){
        this.usuarioRepository.deleteById(usuarioId);
    }

//Listar Dispositivos cadastrados em um determinado Usuario   (CERTO)
    public Optional<List<Dispositivo>> listarDispositivosCadastradosEmUmUsuario(Long usuarioId){
        return this.usuarioRepository.findById(usuarioId).map(Usuario::getDispositivos);
    }

//Setar Dispositivos a um Usuario:
    public Dispositivo vincularDispositivoExistenteEmUmUsuarioExistente(Long usuarioId, Long dispositivoId){
        Usuario usuario = this.usuarioRepository.findById(usuarioId)
                .orElseThrow(()-> new UsuarioNaoEncontradoException("Usuário com o id " + usuarioId + " não encontrado!"));

        Dispositivo dispositivo = this.dispositivoRepository.findById(dispositivoId)
                .orElseThrow(() -> new DispositivoNaoEncontradoException("Dispositivo com o id " + dispositivoId + " não encontrado!"));

        dispositivo.setUsuario(usuario);
        return this.dispositivoRepository.save(dispositivo);

    }


//Setar Departamento a um Usuario:
    public Usuario vincularDepartamentoExistenteEmUmUsuarioExistente(Long usuarioId, Long departamentoId){

        Usuario usuario = this.usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário com o id " + usuarioId + " não encontrado!"));

        Departamento departamento = this.departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new DepartamentoNaoEncontradoException("Departamento com o id " + departamentoId + " não encontrado!"));

        usuario.setDepartamento(departamento);

        return this.usuarioRepository.save(usuario);
    }


//Buscar Departamento do Usuario (CERTO)
    public Optional<Departamento> buscarDepartamentoDoUsuario(Long usuarioId){
        return this.usuarioRepository.findById(usuarioId).map(Usuario::getDepartamento);
    }


}
