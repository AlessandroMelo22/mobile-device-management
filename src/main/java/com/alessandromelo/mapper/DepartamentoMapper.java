package com.alessandromelo.mapper;

import com.alessandromelo.dto.departamento.DepartamentoRequestDTO;
import com.alessandromelo.dto.departamento.DepartamentoResponseDTO;
import com.alessandromelo.model.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    //RequestDTO -> Entity:
    public Departamento toEntity(DepartamentoRequestDTO departamentoRequestDTO){

        Departamento departamento = new Departamento();

        departamento.setNome(departamentoRequestDTO.getNome());
        departamento.setSigla(departamentoRequestDTO.getSigla());

        return departamento;
    }

    //Entity -> ResponseDTO
    public DepartamentoResponseDTO toResponseDTO(Departamento departamento){

        DepartamentoResponseDTO departamentoResponseDTO = new DepartamentoResponseDTO();

        departamentoResponseDTO.setId(departamento.getId());
        departamentoResponseDTO.setNome(departamento.getNome());
        departamentoResponseDTO.setSigla(departamento.getSigla());


        return departamentoResponseDTO;
    }
}
