package com.desenvolvimentoWeb.desafioII.service;

import com.desenvolvimentoWeb.desafioII.model.Destino;
import com.desenvolvimentoWeb.desafioII.repository.DestinoRepositorio;
import java.util.List;
import java.util.Optional;

public class DestinoServico {

    private final DestinoRepositorio repositorio = new DestinoRepositorio();

    public Destino adicionarDestino(Destino destino) {
        return repositorio.adicionar(destino);
    }

    public List<Destino> listarTodos() {
        return repositorio.listar();
    }

    public Destino buscarPorId(Long id) {
        Optional<Destino> destino = repositorio.buscarPorId(id);
        if (destino.isPresent()) {
            return destino.get();
        } else {
            throw new RuntimeException("Destino não encontrado");
        }
    }

    public Destino atualizarDestino(Long id, Destino destinoAtualizado) {
        return repositorio.atualizar(id, destinoAtualizado);
    }

    public Destino atualizarAvaliacao(Long id, double novaAvaliacao) {
        if (novaAvaliacao < 1 || novaAvaliacao > 10) {
            throw new IllegalArgumentException("A avaliação deve ser entre 1 e 10.");
        }
        Destino destino = buscarPorId(id);
        destino.avaliacao(novaAvaliacao);
        return repositorio.atualizar(id, destino);
    }

    public void deletarDestino(Long id) {
        repositorio.deletar(id);
    }
}