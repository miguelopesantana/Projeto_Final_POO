package com.company;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    protected List<Cliente> clientesFrequentes;
    protected List<Cliente> clientesNormais;
    protected List<Produto> produtosDisponiveis;
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

    }

    public void mudarData() {
    }
}