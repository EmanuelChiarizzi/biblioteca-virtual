package com.biblioteca.biblioteca_virtual.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class livrodto {

    @NotBlank(message = "titulo e obrigatorio")
    @Size(max = 255)
    private String titulo;

    @NotBlank(message = "autor e obrigatorio")
    @Size(max = 255)
    private String autor;

    @NotBlank(message = "isbn e obrigatorio")
    @Size(max = 255)
    private String isbn;

    @Min(1500)
    private Integer anoPublicacao;

    @Size(max = 255)
    private String descricao;

    private Boolean disponivel = true;

}