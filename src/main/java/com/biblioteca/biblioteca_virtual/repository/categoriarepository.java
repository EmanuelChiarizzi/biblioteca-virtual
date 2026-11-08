package com.biblioteca.biblioteca_virtual.repository;

import com.biblioteca.biblioteca_virtual.model.categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoriarepository extends JpaRepository<categoria, Long> {
}