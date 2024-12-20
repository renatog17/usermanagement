package com.gti.javapleno.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gti.javapleno.usermanagement.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
