package com.biblioteca.biblioteca_virtual.controller;
import com.biblioteca.biblioteca_virtual.dto.autordto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;

import com.biblioteca.biblioteca_virtual.model.autor;
import com.biblioteca.biblioteca_virtual.service.autorservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/autors")
public class autorcontroller {

    private final autorservice service;

    public autorcontroller(autorservice service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public autor cadastrar(@Valid @RequestBody autordto dados) {
        return service.cadastrar(converter(dados));
    }

    @GetMapping
    public List<autor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public autor buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public autor atualizar(@PathVariable Long id, @Valid @RequestBody autordto dados) {
        return service.atualizar(id, converter(dados));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    private autor converter(autordto dados) {
        autor entidade = new autor();
        BeanUtils.copyProperties(dados, entidade);
        return entidade;
    }
}