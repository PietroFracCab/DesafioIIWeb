package com.desenvolvimentoWeb.desafioII.service;

import com.desenvolvimentoWeb.desafioII.model.Destino;
import com.desenvolvimentoWeb.desafioII.repository.DestinoRepositorio;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoServico {

    @Autowired
    private final DestinoRepositorio repositorio;

    public DestinoServico(DestinoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Destino adicionarDestino(Destino destino) {
        return repositorio.save(destino);
    }

    public List<Destino> listarTodos() {
        return repositorio.findAll();
    }

    public Destino buscarPorId(Long id) {
        Optional<Destino> destino = repositorio.findById(id);
        return destino.orElseThrow(() -> new RuntimeException("Destino não encontrado"));
    }

    public Destino atualizarDestino(Long id, Destino destinoAtualizado) {
        if (!repositorio.existsById(id)) {
            throw new RuntimeException("Destino não encontrado");
        }
        destinoAtualizado.setId(id);
        return repositorio.save(destinoAtualizado);
    }

    public Destino atualizarAvaliacao(Long id, double novaAvaliacao) {
        if (novaAvaliacao < 1 || novaAvaliacao > 10) {
            throw new IllegalArgumentException("A avaliação deve ser entre 1 e 10.");
        }
        Destino destino = buscarPorId(id);
        destino.setAvaliacao(novaAvaliacao);
        return repositorio.atualizar(id, destino);
    }

    public void deletarDestino(Long id) {
        repositorio.deleteById(id);
    }
}