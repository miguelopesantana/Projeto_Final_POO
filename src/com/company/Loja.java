package com.company;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    protected List<Cliente> clientesFrequentes;
    protected List<Cliente> clientesNormais;
    protected List<Produto> produtosDisponiveis;
    protected List<Compra> listaCompras;
    //protected List<Promocoes> produtosPromocao;

    public Loja(){
        clientesFrequentes = new ArrayList<>();
        clientesNormais = new ArrayList<>();
        produtosDisponiveis = new ArrayList<>();
        //produtosPromocao = new ArrayList<>();
    }

    public void comprar(){
        
    }


    public void consultar() {
        for(Compra compra: listaCompras){
            System.out.println(compra.toString());
        }

    }

    public void mudarData() {
    }
}