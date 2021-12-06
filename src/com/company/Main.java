package com.company;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Loja loja = new Loja();
        File fclientesf = new File("ClientesF.txt");
        File fclientesr = new File("ClientesR.txt");
        File produtos = new File("Produtos.txt");
        loja.update(fclientesf, fclientesr, produtos);

        /*
        String dia = "";
        float amp = 0;

        File f = new File("tempo.txt");
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    float min = Float.parseFloat(parts[1]);
                    float max = Float.parseFloat(parts[2]);
                    if(max - min>= amp)
                        amp = max - min;
                    dia = parts[0];
                }
                System.out.printf("Dia %s -> Amplitude %.1f", dia, amp);
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
        */


        int escolha;
        Scanner stdin = new Scanner(System.in);
        while (true) {// Menu
            System.out.println("MENU---------------------------------------------------");
            System.out.println("1 - Dar login");
            System.out.println("2 - Comprar items");
            System.out.println("3 - Consultar as compras");
            System.out.println("4 - Mudar a data");
            escolha = stdin.nextInt();
            System.out.println("--------------------------------------------------------\n");
            switch (escolha) {
                case 1 -> login(fclientesf, fclientesr);
                case 2 -> loja.comprar();
                case 3 -> loja.consultar();
                case 4 -> loja.mudarData();
                case 0 -> System.exit(0);
            }
        }

    }

    public static void login(File cf, File cr){
        System.out.printf("Introduza o seu email:\n");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();

        //lê ficheiro

        if (cf.exists() && cf.isFile()) {
            try {
                FileReader fr = new FileReader(cf);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while ((line = br.readLine()) != null) {
                    int i = 0;
                    String[] parts = line.split(";");
                    String mail = parts[3];
                    String nome = parts[1];
                    //se o email introduzido pelo user for igual a algum email que está no ficheiro de texto, log in feito
                    if (Objects.equals(email, mail)) {
                        System.out.printf("Login concluído com sucesso!\n");
                        System.out.printf("Bem vindo %s\n", nome);
                        break;
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
}
