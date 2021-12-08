package com.company;

import java.io.Serializable;

/**
 * Classe que caracteriza uma Compra
 * @author Guilherme Faria e Miguel Santana
 */

public class Compra {
    protected String nome;
    protected int quantidade;
    protected float preco;
    protected boolean promo;

    /**
     * Construtor
     * @param produto nome do produto
     * @param quantidade quantidade de produtos do mesmo tipo que o cliente pertende comprar
     * @param preco preço total da compra a realizar
     */

    public Compra(String produto, int quantidade , float preco, boolean promocao){
        this.nome = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Função que recebe como parâmetro um inteiro e define a variável preço com o valor desse inteiro
     * @param preco preço total da compra a realizar
     */

    public void setPreco(float preco) {
        this.preco = preco;
    }

//    /**
//     * Método que permite imprimir as características de uma compra
//     * @return uma string com todas as características da Classe Compra
//     */

//    @Override
//    public String toString() {
//        return "Compra{" +
//                "produto='" + nome + '\'' +
//                ", quantidade=" + quantidade +
//                '}';
//    }
}
