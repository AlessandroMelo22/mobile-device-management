package com.alessandromelo.controller;

import com.alessandromelo.dto.departamento.DepartamentoRequestDTO;
import com.alessandromelo.dto.departamento.DepartamentoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioResumoResponseDTO;
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
    public ResponseEntity<List<DepartamentoResponseDTO>> listarTodosDepartamentos(){
        return ResponseEntity.ok(this.departamentoService.listarTodosDepartamentos());
    }

//Buscar Departamento por id: (CERTO)
    @GetMapping("/{departamentoId}")
    public ResponseEntity<DepartamentoResponseDTO> buscarDepartamentoPorId(@PathVariable Long departamentoId){
        return ResponseEntity.ok(this.departamentoService.buscarDepartamentoPorId(departamentoId));
    }

//Cadastrar novo Departamento: (CERTO)
    @PostMapping
    public ResponseEntity<DepartamentoResponseDTO> criarNovoDepartamento(@RequestBody DepartamentoRequestDTO novoDepartamentoDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.departamentoService.criarNovoDepartamento(novoDepartamentoDTO));
    }

//Atualizar Departamento:
    @PutMapping("/{departamentoId}")
    public ResponseEntity<DepartamentoResponseDTO> atualizarDepartamento(@PathVariable Long departamentoId,
                                                                         @RequestBody DepartamentoRequestDTO departamentoAtualizadoDTO){
        return ResponseEntity.ok(this.departamentoService.atualizarDepartamento(departamentoId, departamentoAtualizadoDTO));
    }

//Remover Departamento por id:
    @DeleteMapping("/{departamentoId}")
    public ResponseEntity<Void> removerDepartamentoPorId(@PathVariable Long departamentoId){
        this.departamentoService.removerDepartamentoPorId(departamentoId);
        return ResponseEntity.noContent().build(); //204
    }

//Listar Usuarios que pertencem a um Departamento:
    @GetMapping("/{departamentoId}/usuarios")
    public ResponseEntity<List<UsuarioResumoResponseDTO>> listarUsuariosDoDepartamento(@PathVariable Long departamentoId){
        return ResponseEntity.ok(this.departamentoService.listarUsuariosDoDepartamento(departamentoId));
    }
}
