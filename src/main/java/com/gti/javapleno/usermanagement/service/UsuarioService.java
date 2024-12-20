package com.gti.javapleno.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gti.javapleno.usermanagement.controller.dto.UsuarioPostDTO;
import com.gti.javapleno.usermanagement.domain.Usuario;
import com.gti.javapleno.usermanagement.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario createUser(UsuarioPostDTO usuarioPostDTO) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioPostDTO.nome());
        usuario.setEmail(usuarioPostDTO.email());
        usuario.setSenha(usuarioPostDTO.senha());
        return usuarioRepository.save(usuario);
    }
}