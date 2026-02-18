package com.example.actividad_desarrollo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.actividad_desarrollo.dto.ProgramaResponseDTO;
import com.example.actividad_desarrollo.dto.UsuarioResponseDTO;
import com.example.actividad_desarrollo.model.Usuario;
import com.example.actividad_desarrollo.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO crearUsuario(Usuario usuario) {
        Usuario guardado = usuarioRepository.save(usuario);

        return UsuarioResponseDTO.builder()
                .nombre(guardado.getNombre().toUpperCase())
                .apellido(guardado.getApellido().toUpperCase())
                .build();
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public ProgramaResponseDTO obtenerNombreCompleto(String nombre, String apellido) {
        return ProgramaResponseDTO.builder()
                .nombreCompleto(nombre + " " + apellido)
                .build();
    }
}