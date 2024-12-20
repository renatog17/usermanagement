package com.gti.javapleno.usermanagement.controller.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String errorMessage = "Ocorreu um erro ao tentar processar a solicitação. Verifique os dados e tente novamente.";
        
        if (ex.getCause() != null && ex.getCause().getMessage().contains("violou a restrição de unicidade")) {
            errorMessage = "O email fornecido já está em uso. Por favor, escolha outro.";
        }

        ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "Violação de restrição de unicidade",
            errorMessage
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}