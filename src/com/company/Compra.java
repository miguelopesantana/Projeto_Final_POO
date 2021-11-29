package com.company;

public class Compra {
    protected String produto;
    protected int quantidade;
   //protected int valorCompra;

    public Compra(String produto, int quantidade /*int valorCompra*/){
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
