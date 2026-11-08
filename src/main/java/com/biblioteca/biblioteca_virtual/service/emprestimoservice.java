package com.biblioteca.biblioteca_virtual.service;

import com.biblioteca.biblioteca_virtual.model.emprestimo;
import com.biblioteca.biblioteca_virtual.repository.emprestimorepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class emprestimoservice {

    private final emprestimorepository repository;

    public emprestimoservice(emprestimorepository repository) {
        this.repository = repository;
    }

    public emprestimo cadastrar(emprestimo dados) {
        dados.setId(null);
        return repository.save(dados);
    }

    public List<emprestimo> listar() {
        return repository.findAll();
    }

    public emprestimo buscar(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Registro nao encontrado"));
    }

    public emprestimo atualizar(Long id, emprestimo dados) {
        emprestimo registro = buscar(id);
        registro.setNomeAluno(dados.getNomeAluno());
        registro.setMatriculaAluno(dados.getMatriculaAluno());
        registro.setDataEmprestimo(dados.getDataEmprestimo());
        registro.setDataDevolucao(dados.getDataDevolucao());
        registro.setLivro(dados.getLivro());
        return repository.save(registro);
    }

    public void excluir(Long id) {
        repository.delete(buscar(id));
    }
}