package com.example.actividad_desarrollo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.actividad_desarrollo.model.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,Long>{
    Optional<Usuario> findByUsername(String username);
}

