package com.example.actividad_desarrollo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.actividad_desarrollo.dto.ProgramaResponseDTO;
import com.example.actividad_desarrollo.dto.UsuarioResponseDTO;
import com.example.actividad_desarrollo.model.Usuario;
import com.example.actividad_desarrollo.repository.UsuarioRepository;
import com.example.actividad_desarrollo.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponseDTO crearUsuario(Usuario usuario) {
        Usuario guardado = usuarioRepository.save(usuario);

        return UsuarioResponseDTO.builder()
                .nombre(guardado.getNombre().toUpperCase())
                .apellido(guardado.getApellido().toUpperCase())
                .build();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public ProgramaResponseDTO obtenerNombreCompleto(String nombre, String apellido) {
        return ProgramaResponseDTO.builder()
                .nombreCompleto(nombre + " " + apellido)
                .build();
    }
}