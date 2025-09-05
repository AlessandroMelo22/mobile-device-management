package com.alessandromelo.repository;

import com.alessandromelo.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<Agente, Long> {

    //Aparentemente nao precisa criar métodos de validação, Agente não tem campos únicos
}
