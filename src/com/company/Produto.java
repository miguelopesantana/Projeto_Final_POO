package com.company;

import java.util.Arrays;

/**
 * Classe que representa um produto e os seus atributos individuais
 * @author Guilherme Faria e Miguel Santana
 *
 */

abstract class Produto {
    int tipo;
    int indentificador;
    String nome;
    float preco;
    int stock;
    Promocao promo;

    /**
     * Construtor
     * @param tipo representa o tipo de produto (Alimentar, Limpeza ou Mobiliário)
     * @param indentificador representa o identificador de cada produto
     * @param nome representa o nome do produto
     * @param preco representa o preço unitário de cada produto
     * @param stock representa a quantidade de produtos disponíveis (stock disponível)
     * @param promo representa a promoção associada ao produto
     */

    public Produto(int tipo, int indentificador, String nome, float preco, int stock, Promocao promo) {
        this.tipo = tipo;
        this.indentificador = indentificador;
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
        this.promo = promo;
    }
    
     //comento o quê aqui??

    public int getPeso() {
        return 0;
    }

    /**
     * Método que permite recolher o valor das datas associadas à promoção em questão
     * @param n inteiro que permite averiguar se se trata da data de início ou do fim da promoção
     * @return retorna uma string com a respetiva data 
     */

    public String getData(int n) {
        switch (n) {
            case 0 -> {
                return this.promo.datai[0] + "/" + this.promo.datai[1] + "/" + this.promo.datai[2];
            }
            case 1 -> {
                return this.promo.dataf[0] + "/" + this.promo.dataf[1] + "/" + this.promo.dataf[2];
            }
        }
        return null;
    }

    /**
     * Método que identifica o tipo de promoção associada a um produto
     * @param n inteiro que define se existe uma promoção associada a um produto e, se caso exista, qual o tipo de promoção
     * @return retorna uma mensagem caso não haja uma promoção associada,
     *         ou, caso haja, retorna a promoção associada bem como as datas de início e fim da respetiva promoção
     */

    public String toStringPromo(int n) {
        String[] promo = {"Pague-3-leve-4", "Pague-menos"};
        switch (n) {
            case 0 -> {
                return "Não há promoções disponíveis para este produto.";
            }
            case 1, 2 -> {
                return "Promoção disponível: " + promo[n-1] + "\nData de início: " + getData(0) + "  Data de fim: " + getData(1);
            }
        }
        return null;
    }
    /**
     * Método que permite imprimir as características de um Produto
     * @return retorna uma string com todas as características da Classe Produto
     */
    
    @Override
    public String toString() {
        return "" + nome + "  Preço: " + String.format("%.2f", preco) + "€  Stock: " + stock;
    }

}
