package com.company;

public class Compra {
    protected String produto;
    protected int quantidade;
    protected boolean promocao;

    public Compra(String produto, int quantidade , boolean promocao){
        this.produto = produto;
        this.quantidade = quantidade;
        this.promocao = promocao;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
