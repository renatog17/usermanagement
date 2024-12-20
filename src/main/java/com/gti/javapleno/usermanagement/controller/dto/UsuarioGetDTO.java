package com.gti.javapleno.usermanagement.controller.dto;

import java.time.LocalDateTime;

public record UsuarioGetDTO(
	    Long id,
	    String nome,
	    String email,
	    LocalDateTime dataCadastro
	) {}