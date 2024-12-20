package com.gti.javapleno.usermanagement.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gti.javapleno.usermanagement.controller.dto.UsuarioGetDTO;
import com.gti.javapleno.usermanagement.controller.dto.UsuarioPostDTO;
import com.gti.javapleno.usermanagement.domain.Usuario;
import com.gti.javapleno.usermanagement.service.UsuarioService;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioGetDTO>> getAllUsers() {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        List<UsuarioGetDTO> usuariosGetDTO = usuarios.stream()
                .map(usuario -> new UsuarioGetDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataCadastro()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuariosGetDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioGetDTO> createUser(@RequestBody UsuarioPostDTO usuarioPostDTO, UriComponentsBuilder uriComponentsBuilder) {
        Usuario usuario = usuarioService.createUser(usuarioPostDTO);
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataCadastro());
    
        URI uri = uriComponentsBuilder.path("/api/users/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuarioGetDTO);
    }
}