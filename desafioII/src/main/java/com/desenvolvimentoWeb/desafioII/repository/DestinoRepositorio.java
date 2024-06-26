package com.desenvolvimentoWeb.desafioII.repository;

import com.desenvolvimentoWeb.desafioII.model.Destino;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class DestinoRepositorio {
    private List<Destino> destinos = new ArrayList<>();
    private AtomicLong contadorId = new AtomicLong();

    public Destino adicionar(Destino destino) {
        destino.setId(contadorId.incrementAndGet());
        destinos.add(destino);
        return destino;
    }

    public List<Destino> listar() {
        return new ArrayList<>(destinos);
    }

    public Optional<Destino> buscarPorId(Long id) {
        return destinos.stream()
                .filter(destino -> destino.getId() == id)
                .findFirst();
    }

    public Destino atualizar(Long id, Destino destinoAtualizado) {
        Optional<Destino> destinoExistente = buscarPorId(id);
        destinoExistente.ifPresent(destino -> {
            int index = destinos.indexOf(destino);
            destinoAtualizado.setId(id);
            destinos.set(index, destinoAtualizado);
        });
        return destinoAtualizado;
    }

    public void deletar(Long id) {
        destinos.removeIf(destino -> destino.getId() == id);
    }
}