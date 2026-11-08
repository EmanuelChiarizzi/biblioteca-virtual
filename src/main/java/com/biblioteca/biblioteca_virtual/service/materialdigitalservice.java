package com.biblioteca.biblioteca_virtual.service;

import com.biblioteca.biblioteca_virtual.model.materialdigital;
import com.biblioteca.biblioteca_virtual.repository.materialdigitalrepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class materialdigitalservice {

    private final materialdigitalrepository repository;

    public materialdigitalservice(materialdigitalrepository repository) {
        this.repository = repository;
    }

    public materialdigital cadastrar(materialdigital dados) {
        dados.setId(null);
        return repository.save(dados);
    }

    public List<materialdigital> listar() {
        return repository.findAll();
    }

    public materialdigital buscar(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Registro nao encontrado"));
    }

    public materialdigital atualizar(Long id, materialdigital dados) {
        materialdigital registro = buscar(id);
        registro.setTitulo(dados.getTitulo());
        registro.setTipoArquivo(dados.getTipoArquivo());
        registro.setUrl(dados.getUrl());
        registro.setDescricao(dados.getDescricao());
        return repository.save(registro);
    }

    public void excluir(Long id) {
        repository.delete(buscar(id));
    }
}