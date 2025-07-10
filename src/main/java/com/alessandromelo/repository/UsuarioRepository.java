package com.alessandromelo.repository;

import com.alessandromelo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);
    boolean existsByMatricula(String matricula);

    boolean existsByEmailAndIdNot(String email, Long id);
    boolean existsByMatriculaAndIdNot(String matricula,Long id);
}
