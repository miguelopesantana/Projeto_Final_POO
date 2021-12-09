package com.company;

import java.io.Serializable;

/**
 * Classe que caracteriza uma Compra
 * @author Guilherme Faria e Miguel Santana
 */

public class Compra implements Serializable {
    protected int identificador;
    protected String nome;
    protected int quantidade;
    protected float preco;

    /**
     * Construtor
     * @param produto nome do produto
     * @param quantidade quantidade de produtos do mesmo tipo que o cliente pertende comprar
     * @param preco preço total da compra a realizar
     */

    protected Compra(int identificador, String produto, int quantidade , float preco){
        this.identificador = identificador;
        this.nome = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /**
     * Função que recebe como parâmetro um inteiro e define a variável quantidade com o valor desse inteiro
     * @param quantidade corresponde à quantidade de produtos do mesmo tipo que o cliente pretende comprar
     */

    protected void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Função que recebe como parâmetro um inteiro e define a variável preço com o valor desse inteiro
     * @param preco preço total da compra a realizar
     */

    protected void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * Método que permite imprimir as características de uma compra
     * @return uma string com todas as características da Classe Compra
     */

    @Override
    public String toString() {
        return "       " + this.quantidade + " " + this.nome + " " + String.format("%.2f", this.preco) +  "€\n";
    }
}
