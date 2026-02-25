package com.example.actividad_desarrollo.service;

import java.util.List;



import com.example.actividad_desarrollo.dto.ProgramaResponseDTO;
import com.example.actividad_desarrollo.dto.UsuarioResponseDTO;
import com.example.actividad_desarrollo.model.Usuario;



public interface UsuarioService {

    UsuarioResponseDTO crearUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    Usuario obtenerPorId(Long id);

    ProgramaResponseDTO obtenerNombreCompleto(String nombre, String apellido);
}