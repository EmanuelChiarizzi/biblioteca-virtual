
package com.biblioteca.biblioteca_virtual.controller;
import com.biblioteca.biblioteca_virtual.dto.livrodto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;

import com.biblioteca.biblioteca_virtual.model.livro;
import com.biblioteca.biblioteca_virtual.service.LivroService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class livrocontroller {

    private final LivroService service;

    public livrocontroller(LivroService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public livro cadastrar(@Valid @RequestBody livrodto dados) {
        return service.cadastrar(converter(dados));
    }

    @GetMapping
    public List<livro> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public livro buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public livro atualizar(@PathVariable Long id, @Valid @RequestBody livrodto dados) {
        return service.atualizar(id, converter(dados));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }

    @GetMapping("/pesquisar")
    public List<livro> pesquisar(@RequestParam String titulo) {
        return service.pesquisarPorTitulo(titulo);
    }

    private livro converter(livrodto dados) {
        livro entidade = new livro();
        BeanUtils.copyProperties(dados, entidade);
        return entidade;
    }
}

