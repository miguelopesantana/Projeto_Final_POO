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
    protected List<Cliente> clientesNormais;
    protected List<Produto> produtosDisponiveis;
    protected List<Compra> listaCompras;
    //protected List<Promocoes> produtosPromocao;

    public Loja() {
        clientesFrequentes = new ArrayList<>();
        clientesNormais = new ArrayList<>();
        produtosDisponiveis = new ArrayList<>();
        //produtosPromocao = new ArrayList<>();
    }

    public void update(File fcf, File fcr, File p){
        lerClientes(fcr, 0);
        lerClientes(fcf, 1);
        lerProdutos(p);
    }

    public void lerClientes(File f, int n){
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    switch (n) {
                        case 0 -> clientesNormais.add(new Cliente(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                        case 1 -> clientesFrequentes.add(new Cliente(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
                    }
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

    public void lerProdutos(File f){
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while ((line = br.readLine()) != null) {
                    String[] l = line.split(";");
                    switch (Integer.parseInt(l[0])) {
                        case 0 -> produtosDisponiveis.add(new ProdutoAlimentar(Integer.parseInt(l[0]), l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Integer.parseInt(l[4]), Integer.parseInt(l[5])));
                        case 1 -> produtosDisponiveis.add(new ProdutoLimpeza(Integer.parseInt(l[0]), l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Integer.parseInt(l[4])));
                        case 2 -> produtosDisponiveis.add(new ProdutoMobiliario(Integer.parseInt(l[0]), l[1], Integer.parseInt(l[2]), Integer.parseInt(l[3]), Integer.parseInt(l[4]), Integer.parseInt(l[5]), Integer.parseInt(l[6]), Integer.parseInt(l[7])));
                    }
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

    public void comprar() {

    }


    public void consultar() {
        for (Compra compra : listaCompras) {
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
        while (!Data.verificaData(dia, mes, ano)) {
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