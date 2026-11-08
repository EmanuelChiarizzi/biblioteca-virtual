package com.biblioteca.biblioteca_virtual.controller;
import com.biblioteca.biblioteca_virtual.dto.categoriadto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;

import com.biblioteca.biblioteca_virtual.model.categoria;
import com.biblioteca.biblioteca_virtual.service.categoriaservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class categoriacontroller {

    private final categoriaservice service;

    public categoriacontroller(categoriaservice service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public categoria cadastrar(@Valid @RequestBody categoriadto dados) {
        return service.cadastrar(converter(dados));
    }

    @GetMapping
    public List<categoria> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public categoria buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public categoria atualizar(@PathVariable Long id, @Valid @RequestBody categoriadto dados) {
        return service.atualizar(id, converter(dados));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    private categoria converter(categoriadto dados) {
        categoria entidade = new categoria();
        BeanUtils.copyProperties(dados, entidade);
        return entidade;
    }
}