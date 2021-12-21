package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que caracteriza um Recibo,
 * lista de produtos de uma compra
 * @author Guilherme Faria e Miguel Santana
 */

public class Recibo implements Serializable {
    protected List<Compra> Compras;
    protected int precot;

    /**
     * Construtor
     * inicia a lista de compras
     */

    public Recibo() {
        Compras = new ArrayList<>();
    }

    /**
     * Método que recebe um inteiro e define a variável precot com o valor do inteiro
     * @param precot preço total da compra associada ao recibo
     */

    protected void setPrecot(int precot) {
        this.precot = precot;
    }

    /**
     * Método que permite imprimir o recibo das compras efetuadas pelo utilizador
     * @return uma string com todas as características do recibo associado a cada compra
     */


    @Override
    public String toString() {
        return "Recibo: (Quant / Produto / Preço)\n" +
                " " + Compras +
                "Total: " + precot + "€\n";
    }
}
