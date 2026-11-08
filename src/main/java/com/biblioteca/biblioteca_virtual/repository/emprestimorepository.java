package com.biblioteca.biblioteca_virtual.repository;

import com.biblioteca.biblioteca_virtual.model.emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface emprestimorepository extends JpaRepository<emprestimo, Long> {
}