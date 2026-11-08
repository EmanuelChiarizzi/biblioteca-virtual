package com.biblioteca.biblioteca_virtual.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class erros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> validacao(
            MethodArgumentNotValidException ex) {

        Map<String, String> campos = new LinkedHashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(erro ->
            campos.put(erro.getField(), erro.getDefaultMessage())
        );

        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("status", 400);
        resposta.put("mensagem", "Dados invalidos");
        resposta.put("campos", campos);

        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> recurso(
            ResponseStatusException ex) {

        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("status", ex.getStatusCode().value());
        resposta.put("mensagem",
            ex.getReason() == null ? "Erro na requisicao" : ex.getReason());

        return ResponseEntity.status(ex.getStatusCode()).body(resposta);
    }
}