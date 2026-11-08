package com.biblioteca.biblioteca_virtual.service;

import com.biblioteca.biblioteca_virtual.model.categoria;
import com.biblioteca.biblioteca_virtual.repository.categoriarepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class categoriaservice {

    private final categoriarepository repository;

    public categoriaservice(categoriarepository repository) {
        this.repository = repository;
    }

    public categoria cadastrar(categoria dados) {
        dados.setId(null);
        return repository.save(dados);
    }

    public List<categoria> listar() {
        return repository.findAll();
    }

    public categoria buscar(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Registro nao encontrado"));
    }

    public categoria atualizar(Long id, categoria dados) {
        categoria registro = buscar(id);
        registro.setNome(dados.getNome());
        registro.setDescricao(dados.getDescricao());
        registro.setAreaConhecimento(dados.getAreaConhecimento());
        registro.setPublicoAlvo(dados.getPublicoAlvo());
        return repository.save(registro);
    }

    public void excluir(Long id) {
        repository.delete(buscar(id));
    }
}