package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.printf("Insira a data:\n");
        System.out.printf("Dia: ");
        Scanner sc = new Scanner(System.in);
        int dia = sc.nextInt();
        System.out.printf("Mês: ");
        Scanner sc1 = new Scanner(System.in);
        int mes = sc1.nextInt();
        System.out.printf("Ano: ");
        Scanner sc2 = new Scanner(System.in);
        int ano = sc2.nextInt();
        while(!Data.verificaData(dia,mes,ano)) {
            System.out.printf("Insira a data:\n ");
            System.out.printf("Dia: ");
            Scanner sc3 = new Scanner(System.in);
            dia = sc3.nextInt();
            System.out.printf("Mês: ");
            Scanner sc4 = new Scanner(System.in);
            mes = sc4.nextInt();
            System.out.printf("Ano: ");
            Scanner sc5 = new Scanner(System.in);
            ano = sc5.nextInt();
        }
        Data data = new Data(dia, mes, ano);
    }
}