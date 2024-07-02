package com.desenvolvimentoWeb.desafioII.controller;

import com.desenvolvimentoWeb.desafioII.model.Destino;
import com.desenvolvimentoWeb.desafioII.repository.DestinoRepositorio;
import com.desenvolvimentoWeb.desafioII.service.DestinoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoControlador {

    private final DestinoServico servico;

    @Autowired
    public DestinoControlador(DestinoRepositorio repositorio) {
        this.servico = new DestinoServico(repositorio);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Destino adicionarDestino(@RequestBody Destino destino) {
        return servico.adicionarDestino(destino);
    }

    @GetMapping
    public List<Destino> listarDestinos() {
        return servico.listarTodos();
    }

    @GetMapping("/{id}")
    public Destino buscarDestinoPorId(@PathVariable Long id) {
        return servico.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Destino atualizarDestino(@PathVariable Long id, @RequestBody Destino destino) {
        return servico.atualizarDestino(id, destino);
    }

    @PatchMapping("/{id}")
    public Destino atualizarAvaliacaoDestino(@PathVariable Long id, @RequestBody double novaAvaliacao) {
        return servico.atualizarAvaliacao(id, novaAvaliacao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarDestino(@PathVariable Long id) {
        servico.deletarDestino(id);
    }

    
}

