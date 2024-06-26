package com.desenvolvimentoWeb.desafioII.model;

import java.util.ArrayList;
import java.util.List;

public class Destino {
    private Long id;
    private String nome; //alterar
    private String localizacao; //alterar
    private String descricao; //alterar
    private double avaliacao; //alterar
    
    public void avaliacao(double novaAvaliacao) {
        this.avaliacao = novaAvaliacao;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }

    private static List<Destino> destinos = new ArrayList<>(); //redundante?
        // Método para adicionar destinos à lista (apenas para exemplo)
        public static void adicionarDestino(Destino destino) {
            destinos.add(destino);
    }
    
    // Método para listar todos os destinos (redundante?)
    public static List<Destino> listarTodos() {
        return destinos;
    }

}