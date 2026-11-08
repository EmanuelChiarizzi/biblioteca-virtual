
package com.biblioteca.biblioteca_virtual.service;

import com.biblioteca.biblioteca_virtual.model.livro;
import com.biblioteca.biblioteca_virtual.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public livro cadastrar(livro livro) {
        return repository.save(livro);
    }

    public List<livro> listar() {
        return repository.findAll();
    }

    public livro buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Livro não encontrado"
            ));
    }

    public livro atualizar(Long id, livro dados) {
        livro livro = buscarPorId(id);

        livro.setTitulo(dados.getTitulo());
        livro.setAutor(dados.getAutor());
        livro.setIsbn(dados.getIsbn());
        livro.setAnoPublicacao(dados.getAnoPublicacao());
        livro.setDescricao(dados.getDescricao());
        livro.setDisponivel(dados.getDisponivel());

        return repository.save(livro);
    }

    public void excluir(Long id) {
        livro livro = buscarPorId(id);
        repository.delete(livro);
    }

    public List<livro> pesquisarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }
}
