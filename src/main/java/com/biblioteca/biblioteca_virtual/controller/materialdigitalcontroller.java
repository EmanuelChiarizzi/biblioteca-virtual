package com.biblioteca.biblioteca_virtual.controller;
import com.biblioteca.biblioteca_virtual.dto.materialdigitaldto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;

import com.biblioteca.biblioteca_virtual.model.materialdigital;
import com.biblioteca.biblioteca_virtual.service.materialdigitalservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/materialdigitals")
public class materialdigitalcontroller {

    private final materialdigitalservice service;

    public materialdigitalcontroller(materialdigitalservice service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public materialdigital cadastrar(@Valid @RequestBody materialdigitaldto dados) {
        return service.cadastrar(converter(dados));
    }

    @GetMapping
    public List<materialdigital> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public materialdigital buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PutMapping("/{id}")
    public materialdigital atualizar(@PathVariable Long id, @Valid @RequestBody materialdigitaldto dados) {
        return service.atualizar(id, converter(dados));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    private materialdigital converter(materialdigitaldto dados) {
        materialdigital entidade = new materialdigital();
        BeanUtils.copyProperties(dados, entidade);
        return entidade;
    }
}