package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Loja loja = new Loja();
        File fcf = new File("ClientesF.txt");
        File fcr = new File("ClientesR.txt");
        File fp = new File("Produtos.txt");
        loja.update(fcf, fcr, fp);

        boolean frequente;
        System.out.println("Para navegar na loja é necessário efetuar login.");
        frequente = login(loja, 0);
        while (true) { // Menu
            int escolha;
            Scanner stdin = new Scanner(System.in);
            System.out.println("MENU---------------------------------------------------");
            System.out.println("1 - Mudar de conta");
            System.out.println("2 - Comprar produtos");
            System.out.println("3 - Consultar o histórico de compras");
            System.out.println("4 - Mudar a data");
            System.out.println("0 - Sair do programa");
            escolha = stdin.nextInt();
            System.out.println("--------------------------------------------------------\n");
            switch (escolha) {
                case 1 -> login(loja, 0);
                case 2 -> loja.comprar(frequente);
                case 3 -> loja.listaRecibos();
                case 4 -> loja.mudarData();
                case 0 -> save(loja);
            }
        }


    }

    public static boolean login(Loja loja, int n) {
        if (n == 0) System.out.printf("Introduza o seu email:   ");
        else if (n == 1) System.out.printf("Introduza novamente o seu email:   ");
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();

        if (!verificar(email, loja.clientesFrequentes, 1) && !verificar(email, loja.clientesNormais, 1)) {
            System.out.println("Email não registado.");
            login(loja, 1);
        }

        return verificar(email, loja.clientesFrequentes, 0);

    }

    public static boolean verificar(String email, List<Cliente> list, int n) {
        for (Cliente c : list) {
            if (email.equals(c.email) && n == 1) {
                System.out.println("Login concluído com sucesso!");
                System.out.printf("Bem vindo %s.\n\n", c.nome);
                return true;
            }

        }
        return false;
    }

    public static void save(Loja loja) { //NAO COMENTAR
        File f = new File("ficheiro.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(loja);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
        System.exit(0);
    }
}

