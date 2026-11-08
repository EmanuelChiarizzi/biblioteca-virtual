package com.biblioteca.biblioteca_virtual.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class categoriadto {

    @NotBlank(message = "nome e obrigatorio")
    @Size(max = 255)
    private String nome;

    @Size(max = 255)
    private String descricao;

    @NotBlank(message = "areaConhecimento e obrigatorio")
    @Size(max = 255)
    private String areaConhecimento;

    @NotBlank(message = "publicoAlvo e obrigatorio")
    @Size(max = 255)
    private String publicoAlvo;

}