package com.biblioteca.biblioteca_virtual.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class materialdigitaldto {

    @NotBlank(message = "titulo e obrigatorio")
    @Size(max = 255)
    private String titulo;

    @NotBlank(message = "tipoArquivo e obrigatorio")
    @Size(max = 255)
    private String tipoArquivo;

    @NotBlank(message = "url e obrigatorio")
    @Size(max = 255)
    private String url;

    @Size(max = 255)
    private String descricao;

}