package com.biblioteca.biblioteca_virtual.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class autordto {

    @NotBlank(message = "nome e obrigatorio")
    @Size(max = 255)
    private String nome;

    @NotBlank(message = "nacionalidade e obrigatorio")
    @Size(max = 255)
    private String nacionalidade;

    @Size(max = 255)
    private String biografia;

    @NotBlank(message = "dataNascimento e obrigatorio")
    @Size(max = 255)
    private String dataNascimento;

}