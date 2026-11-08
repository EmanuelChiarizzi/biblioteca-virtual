package com.biblioteca.biblioteca_virtual.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class emprestimodto {

    @NotBlank(message = "nomeAluno e obrigatorio")
    @Size(max = 255)
    private String nomeAluno;

    @NotBlank(message = "matriculaAluno e obrigatorio")
    @Size(max = 255)
    private String matriculaAluno;

    @NotBlank(message = "dataEmprestimo e obrigatorio")
    @Size(max = 255)
    private String dataEmprestimo;

    @NotBlank(message = "dataDevolucao e obrigatorio")
    @Size(max = 255)
    private String dataDevolucao;

    @NotNull(message = "livroId e obrigatorio")
    private Long livroId;

}