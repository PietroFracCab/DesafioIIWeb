package com.desenvolvimentoWeb.desafioII.model;

public class Destino {
    private Long id;
    private String nome;
    private String localizacao;
    private String descricao;
    private double avaliacao;
    
    public void avaliacao(double novaAvaliacao) {
        this.avaliacao = novaAvaliacao;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }
    
    // Construtores, getters e setters aqui
}