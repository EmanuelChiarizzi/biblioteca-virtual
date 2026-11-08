package com.biblioteca.biblioteca_virtual.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "materialdigitals")
@Getter
@Setter
public class materialdigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String tipoArquivo;
    private String url;
    private String descricao;
}