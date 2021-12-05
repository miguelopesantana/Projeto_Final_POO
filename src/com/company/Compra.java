package com.company;

public class Compra {
    protected String produto;
    protected int quantidade;

    public Compra(String produto, int quantidade , boolean promocao){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
