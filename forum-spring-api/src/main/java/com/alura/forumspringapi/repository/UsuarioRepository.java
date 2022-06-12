package com.alura.forumspringapi.repository;

import java.util.Optional;

import com.alura.forumspringapi.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    Optional<Usuario> findByEmail(String email);
}
