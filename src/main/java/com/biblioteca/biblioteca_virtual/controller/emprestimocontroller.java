package com.biblioteca.biblioteca_virtual.controller;
import com.biblioteca.biblioteca_virtual.dto.emprestimodto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import com.biblioteca.biblioteca_virtual.repository.LivroRepository;
import org.springframework.web.server.ResponseStatusException;

import com.biblioteca.biblioteca_virtual.model.emprestimo;
import com.biblioteca.biblioteca_virtual.service.emprestimoservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class emprestimocontroller {

    private final emprestimoservice service;
    private final LivroRepository livrorepository;

    public emprestimocontroller(emprestimoservice service, LivroRepository livrorepository) {
        this.service = service;
        this.livrorepository = livrorepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public emprestimo cadastrar(@Valid @RequestBody emprestimodto dados) {
        return service.cadastrar(converter(dados));
    }

    @GetMapping
    public List<emprestimo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public emprestimo buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public emprestimo atualizar(@PathVariable Long id, @Valid @RequestBody emprestimodto dados) {
        return service.atualizar(id, converter(dados));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    private emprestimo converter(emprestimodto dados) {
        emprestimo entidade = new emprestimo();
        BeanUtils.copyProperties(dados, entidade);
        entidade.setLivro(livrorepository.findById(dados.getLivroId())
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Livro nao encontrado")));
        return entidade;
    }
}