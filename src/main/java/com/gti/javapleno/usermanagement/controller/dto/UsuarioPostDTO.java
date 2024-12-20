package com.gti.javapleno.usermanagement.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioPostDTO(

	    @NotBlank(message = "O nome não pode ser vazio.")
	    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
	    String nome,

	    @NotBlank(message = "O email não pode ser vazio.")
	    @Email(message = "O email deve ser válido.")
	    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
	    String email,

	    @NotBlank(message = "A senha não pode ser vazia.")
	    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
	    String senha
	) {}	