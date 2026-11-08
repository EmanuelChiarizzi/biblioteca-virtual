package com.biblioteca.biblioteca_virtual.service;

import com.biblioteca.biblioteca_virtual.model.autor;
import com.biblioteca.biblioteca_virtual.repository.autorrepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class autorservice {

    private final autorrepository repository;

    public autorservice(autorrepository repository) {
        this.repository = repository;
    }

    public autor cadastrar(autor dados) {
        dados.setId(null);
        return repository.save(dados);
    }

    public List<autor> listar() {
        return repository.findAll();
    }

    public autor buscar(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Registro nao encontrado"));
    }

    public autor atualizar(Long id, autor dados) {
        autor registro = buscar(id);
        registro.setNome(dados.getNome());
        registro.setNacionalidade(dados.getNacionalidade());
        registro.setBiografia(dados.getBiografia());
        registro.setDataNascimento(dados.getDataNascimento());
        return repository.save(registro);
    }

    public void excluir(Long id) {
        repository.delete(buscar(id));
    }
}