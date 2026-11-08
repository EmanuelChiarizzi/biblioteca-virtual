package com.biblioteca.biblioteca_virtual.repository;

import com.biblioteca.biblioteca_virtual.model.livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<livro, Long> {

    List<livro> findByTituloContainingIgnoreCase(String titulo);
}