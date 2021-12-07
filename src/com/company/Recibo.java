package com.company;

import java.util.ArrayList;
import java.util.List;

public class Recibo {
    protected List<Compra> Compras;
    int precot;

    public Recibo() {
        Compras = new ArrayList<>();
    }

    public void setPrecot(int precot) {
        this.precot = precot;
    }

    public void tostring() {
        for (Compra c : Compras) {
            System.out.println("       " + c.quantidade + " " + c.nome + " " + c.preco +  "€\n");
        }
    }
}
