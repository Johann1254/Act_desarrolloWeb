package com.example.actividad_desarrollo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.actividad_desarrollo.dto.ProgramaResponseDTO;
import com.example.actividad_desarrollo.dto.UsuarioResponseDTO;
import com.example.actividad_desarrollo.model.Usuario;
import com.example.actividad_desarrollo.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponseDTO crear(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @GetMapping("/api/params")
    public ProgramaResponseDTO programa(
            @RequestParam String nombre,
            @RequestParam String apellido) {

        return usuarioService.obtenerNombreCompleto(nombre, apellido);
    }
}

