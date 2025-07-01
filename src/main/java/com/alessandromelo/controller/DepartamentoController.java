package com.alessandromelo.controller;

import com.alessandromelo.model.Departamento;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private DepartamentoService departamentoService;



    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }


//Listar todos os Departamentos: (CERTO)
    @GetMapping
    public ResponseEntity<List<Departamento>> listarTodosDepartamentos(){
        return ResponseEntity.ok(this.departamentoService.listarTodosDepartamentos());
    }

//Buscar Departamento por id: (CERTO)
    @GetMapping("/{departamentoId}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable Long departamentoId){

        return this.departamentoService.buscarDepartamentoPorId(departamentoId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//Cadastrar novo Departamento: (CERTO)
    @PostMapping
    public ResponseEntity<Departamento> criarNovoDepartamento(@RequestBody Departamento novoDepartamento){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.departamentoService.criarNovoDepartamento(novoDepartamento));
    }

//Atualizar Departamento:
    @PutMapping("/{departamentoId}")
    public ResponseEntity<Departamento> atualizarDepartamento(@PathVariable Long departamentoId, Departamento atualizado){

        return this.departamentoService.atualizarDepartamento(departamentoId,atualizado)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//Remover Departamento por id:
    @DeleteMapping("/{departamentoId}")
    public ResponseEntity<Void> removerDepartamentoPorId(@PathVariable Long departamentoId){

        this.departamentoService.removerDepartamentoPorId(departamentoId);
        return ResponseEntity.noContent().build(); //204
    }

//Listar Usuarios que pertencem a um Departamento:
    @GetMapping("/{departamentoId}/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuariosDoDepartamento(@PathVariable Long departamentoId){

        return this.departamentoService.listarUsuariosDoDepartamento(departamentoId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
