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

    public Loja(){
        clientesFrequentes = new ArrayList<>();
        clientesNormais = new ArrayList<>();
        produtosDisponiveis = new ArrayList<>();
        //produtosPromocao = new ArrayList<>();
    }

    public void update(File fcf, File fcn, File p){
        if (fcf.exists() && fcf.isFile()) {
            try {
                FileReader fr = new FileReader(fcf);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    String nome = parts[0];
                    String morada = parts[1];
                    String email = parts[2];
                    int num_tel = Integer.parseInt(parts[3]);
                    int data_nasc = Integer.parseInt(parts[4]);

                    Cliente cliente = new Cliente(nome, morada, email, num_tel, data_nasc);
                    clientesFrequentes.add(cliente);
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
        if (fcn.exists() && fcn.isFile()) {
            try {
                FileReader fr = new FileReader(fcn);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while ((line = br.readLine()) != null) {
                    int i = 0;
                    String[] parts = line.split(";");
                    String nome = parts[0];
                    String morada = parts[1];
                    String email = parts[2];
                    int num_tel = Integer.parseInt(parts[3]);
                    int data_nasc = Integer.parseInt(parts[4]);

                    Cliente cliente = new Cliente(nome, morada,email, num_tel, data_nasc);
                    clientesNormais.add(cliente);
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
        if (p.exists() && p.isFile()) {
            try {
                FileReader fr = new FileReader(p);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while ((line = br.readLine()) != null) {
                    int i = 0;
                    String[] parts = line.split(";");
                    int identificador = Integer.parseInt(parts[0]);
                    //produto alimentar
                    if(identificador > 0 && identificador <= 10000){
                        String nome = parts[1];
                        int preco = Integer.parseInt(parts[2]);
                        int stock = Integer.parseInt(parts[3]);
                        int num_cal = Integer.parseInt(parts[4]);
                        int perc_gord = Integer.parseInt(parts[5]);

                        Produto produto = new ProdutoAlimentar(identificador, nome, preco, stock, num_cal, perc_gord);
                        produtosDisponiveis.add(produto);
                    }
                    //Produto limpeza
                    if(identificador > 10000 && identificador <= 20000){
                        String nome = parts[1];
                        int preco = Integer.parseInt(parts[2]);
                        int stock = Integer.parseInt(parts[3]);
                        int toxicidade = Integer.parseInt(parts[4]);

                        Produto produto = new ProdutoLimpeza(identificador, nome, preco, stock, toxicidade);
                        produtosDisponiveis.add(produto);
                    }
                    //produto mobiliário
                    if(identificador > 20000 && identificador <= 30000){
                        String nome = parts[1];
                        int preco = Integer.parseInt(parts[2]);
                        int stock = Integer.parseInt(parts[3]);
                        int peso = Integer.parseInt(parts[4]);
                        int altura = Integer.parseInt(parts[5]);
                        int largura = Integer.parseInt(parts[6]);
                        int profundidade = Integer.parseInt(parts[7]);

                        Produto produto = new ProdutoMobiliario(identificador, nome, preco, stock, peso, altura, largura, profundidade);
                        produtosDisponiveis.add(produto);
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