package com.biblioteca.biblioteca_virtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autors")
@Getter
@Setter
public class autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nacionalidade;
    private String biografia;
    private String dataNascimento;
}