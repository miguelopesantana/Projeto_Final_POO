package com.company;

import java.io.Serializable;

/**
 * Classe que caracteriza um Produto
 * @author Guilherme Faria e Miguel Santana
 *
 */

abstract class Produto implements Serializable {
    protected int tipo;
    protected int indentificador;
    protected String nome;
    protected float preco;
    protected int stock;
    protected Promocao promo;

    /**
     * Construtor
     * @param tipo tipo de produto (Alimentar, Limpeza ou Mobiliário)
     * @param indentificador identificador de cada produto
     * @param nome nome do produto
     * @param preco preço unitário de cada produto
     * @param stock quantidade de produtos disponíveis (stock disponível)
     * @param promo promoção associada ao produto
     */

    public Produto(int tipo, int indentificador, String nome, float preco, int stock, Promocao promo) {
        this.tipo = tipo;
        this.indentificador = indentificador;
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
        this.promo = promo;
    }

    /**
     * Método que permite aceder ao peso do produto
     * @return o peso do produto, caso seja de mobiliário, caso contrário devolve 0
     */

    protected int getPeso() {
        return 0;
    }

    /**
     * Método que permite recolher o valor das datas associadas à promoção em questão
     * @param n inteiro que permite averiguar se se trata da data de início ou do fim da promoção
     * @return retorna uma string com a respetiva data 
     */

    private String getData(int n) {
        switch (n) {
            case 0 -> {
                return this.promo.datai.dia + "/" + this.promo.datai.mes + "/" + this.promo.datai.ano;
            }
            case 1 -> {
                return this.promo.dataf.dia + "/" + this.promo.dataf.mes + "/" + this.promo.dataf.ano;
            }
        }
        return null;
    }

    /**
     * Método que identifica o tipo de promoção associada a um produto
     * @param n define se existe uma promoção associada a um produto e, caso exista, qual o tipo de promoção
     * @return retorna uma mensagem caso não haja uma promoção associada,
     *         ou, caso haja, retorna a promoção associada bem como as datas de início e fim da respetiva promoção
     */

    protected String toStringPromo(int n) {
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
        return "" + nome + "  ID: " + indentificador + "  Preço: " + String.format("%.2f", preco) + "€  Stock: " + stock;
    }

}
