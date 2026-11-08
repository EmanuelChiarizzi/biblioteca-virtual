package com.biblioteca.biblioteca_virtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "emprestimos")
@Getter
@Setter
public class emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeAluno;
    private String matriculaAluno;
    private String dataEmprestimo;
    private String dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private livro livro;
}