package com.biblioteca.biblioteca_virtual.repository;

import com.biblioteca.biblioteca_virtual.model.autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface autorrepository extends JpaRepository<autor, Long> {
}