package com.company;

import java.io.*;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
    protected List<Cliente> clientesFrequentes;
    protected List<Cliente> clientesRegulares;
    protected List<Produto> produtosDisponiveis;
    protected List<Compra> listaCompras;
    //protected List<Promocoes> produtosPromocao;

    public Loja(){
        clientesFrequentes = new ArrayList<>();
        clientesRegulares = new ArrayList<>();
        produtosDisponiveis = new ArrayList<>();
        //produtosPromocao = new ArrayList<>();
    }

    public void update(File fcf, File fcr, File p){

        if (fcf.exists() && fcf.isFile()) {
            try {
                FileReader fr = new FileReader(fcf);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while ((line = br.readLine()) != null) {
                    int i = 0;
                    String[] parts = line.split(";");
                    String mail = parts[3];
                    String nome = parts[1];
                    //se o email introduzido pelo user for igual a algum email que está no ficheiro de texto, log in feito
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
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