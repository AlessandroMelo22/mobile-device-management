package com.alessandromelo.service;

import com.alessandromelo.model.Departamento;
import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
    }
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    //listar todos os usuarios
    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

    //Buscar Usuario por id:
    public Optional<Usuario> buscarUsuarioPorId(Long id){
       return this.usuarioRepository.findById(id);
    }

    //Cadastrar Usuario:
    public void cadastrarUsuario(Usuario usuario){
        this.usuarioRepository.save(usuario);
    }

    //Atualizar Usuario: (CONSERTAR O PROBLEMA DE CAMPOS NULOS)
    public Usuario atualizarUsuario(Long usuarioId, Usuario atualizado){

        Usuario existente = this.usuarioRepository.getReferenceById(usuarioId);

        existente.setNome(atualizado.getNome());
        existente.setCargo(atualizado.getCargo());
        existente.setMatricula(atualizado.getMatricula());
        existente.setEmail(atualizado.getEmail());
        existente.setDepartamento(atualizado.getDepartamento());
        existente.setAtivo(atualizado.getAtivo());
        existente.setDispositivos(atualizado.getDispositivos());

        return this.usuarioRepository.save(existente);
    }

    //Remover Usuario:
    public void removerUsuario(Long usuarioId){
        this.usuarioRepository.deleteById(usuarioId);
    }

    //Listar Dispositivos cadastrados em um determinado Usuario
    public List<Dispositivo> listarDispositivosCadastradosEmUmUsuario(Long usuarioId){
        return this.usuarioRepository.getReferenceById(usuarioId).getDispositivos();
    }

    //Buscar Departamento do Usuario
    public Departamento buscarDepartamentoDoUsuario(Long usuarioId){
        return this.usuarioRepository.getReferenceById(usuarioId).getDepartamento();
    }


}
