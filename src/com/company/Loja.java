package com.company;

import java.io.*;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que representa a Loja
 * @author Guilherme Faria e Miguel Santana
 */

public class Loja {
    protected List<Cliente> clientesFrequentes;
    protected List<Cliente> clientesNormais;
    protected List<Produto> produtosDisponiveis;
    protected List<Compra> Carrinho;
    protected List<Recibo> Recibos;

    /**
     * Construtor
     * Inicia as listas de Clientes Frequentes, Clientes Normais, Produtos Disponíveis, Carrinho e Recibos
     */

    public Loja() {
        clientesFrequentes = new ArrayList<>();
        clientesNormais = new ArrayList<>();
        produtosDisponiveis = new ArrayList<>();
        Carrinho = new ArrayList<>();
        Recibos = new ArrayList<>();
    }

    public void update(File fcf, File fcr, File p) { //NAO COMENTAR

//        lerClientesObj();
//        lerProdutosObj();

        lerClientes(fcr, 0);
        lerClientes(fcf, 1);
        lerProdutos(p);


    }

    

    public void lerClientes(File f, int n) { //NAO COMENTAR
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    switch (n) {
                        case 0 -> clientesNormais.add(new Cliente(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                        case 1 -> clientesFrequentes.add(new Cliente(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
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

    public void lerProdutos(File f) { //NAO COMENTAR
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while ((line = br.readLine()) != null) {
                    String[] l = line.split(";");
                    switch (Integer.parseInt(l[0])) {
                        case 0 -> produtosDisponiveis.add(new ProdutoAlimentar(Integer.parseInt(l[0]), Integer.parseInt(l[1]), l[2], Float.parseFloat(l[3]), Integer.parseInt(l[4]), new Promocao(Integer.parseInt(l[5]), l[6].split("/"), l[7].split("/")), Integer.parseInt(l[8]), Integer.parseInt(l[9].split("%")[0])));
                        case 1 -> produtosDisponiveis.add(new ProdutoLimpeza(Integer.parseInt(l[0]), Integer.parseInt(l[1]), l[2], Float.parseFloat(l[3]), Integer.parseInt(l[4]), new Promocao(Integer.parseInt(l[5]), l[6].split("/"), l[7].split("/")), Integer.parseInt(l[5])));
                        case 2 -> produtosDisponiveis.add(new ProdutoMobiliario(Integer.parseInt(l[0]), Integer.parseInt(l[1]), l[2], Float.parseFloat(l[3]), Integer.parseInt(l[4]), new Promocao(Integer.parseInt(l[5]), l[6].split("/"), l[7].split("/")), Integer.parseInt(l[8]), Integer.parseInt(l[9]), Integer.parseInt(l[10]), Integer.parseInt(l[11])));
                    }
                }
                br.close();
            } catch (NumberFormatException ex) {
                System.out.println("Ficheiro \"Produtos.txt\" contém um erro de sintaxe.");
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }

    /**
     * Este método permite realizar uma compra,
     * apresenta a lista de produtos disponíveis caso esta ainda contenha produtos disponíveis para venda
     * solicita qual o índice do produto que se pretende comprar
     * solicita a quantidade, desse mesmo produto, que se pretende comprar
     * verifica se o produto possui uma promoção e calcula o preço mediante essa verificação
     * verifica o peso do produto caso este seja de mobiliário e ajusta o preço caso este seja superior a 15Kg
     * após estas verificações, adiciona ao carrinho a solicitação de compra
     * apresenta o valor final da compra
     * pergunta ao utilizador se pretende receber o recibo da compra efetuada ou se deseja efetuar outra compra
     *
     * @param frequente boolean que define se o Cliente em questão é Frequente ou Normal
     */

    public void comprar(boolean frequente) {
        if (produtosDisponiveis.size() == 0) {
            System.out.println("Não existem mais produtos disponíveis!\n");
        } else {
            System.out.println("Lista de produtos disponíveis:\n");
            listaprodutosDisponiveis();
            System.out.print("\nSelecione o índice do produto que deseja comprar: ");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            while (i < 0 || i > produtosDisponiveis.size() - 1) {
                System.out.println("Índice inválido.");
                System.out.print("Selecione novamente o índice do produto que deseja comprar: ");
                sc = new Scanner(System.in);
                i = sc.nextInt();
            }
            System.out.print("Introduza a quantidade que deseja comprar: ");
            sc = new Scanner(System.in);
            int q = sc.nextInt();
            while (q < 1 || q > produtosDisponiveis.get(i).stock) {
                System.out.println("Quantidade inválida.");
                System.out.print("Selecione novamente o quantidade do produto que deseja comprar: ");
                sc = new Scanner(System.in);
                q = sc.nextInt();
            }

            int[] existe = {0, 0};
            for (Compra c : Carrinho) {
                if (produtosDisponiveis.get(i).nome.equals(c.nome)) {
                    existe[0] = 1;
                    existe[1] = Carrinho.indexOf(c);
                }
            }
            int qt;
            if (existe[0] == 0) qt = q;
            else qt = q + Carrinho.get(existe[1]).quantidade;

            float preco = 0;
            if (produtosDisponiveis.get(i).promo.tipo == 0) {
                preco = qt*produtosDisponiveis.get(i).preco;
            } else if (produtosDisponiveis.get(i).promo.tipo == 1) {
                if (qt < 4) preco = qt * produtosDisponiveis.get(i).preco;
                else {
//                    System.out.println((qt - (sc.nextInt(qt / 4))));
                    int prom = (qt / 4);
                    preco = (qt - prom) * produtosDisponiveis.get(i).preco;
                }
            } else if (produtosDisponiveis.get(i).promo.tipo == 2) {
                int p;
                for (int k = 0; k < qt; k++) {
                    p = Math.min(k, 10);
//                    System.out.println(produtosDisponiveis.get(i).preco * (1 - (0.05 * p)));
                    preco = (float) (produtosDisponiveis.get(i).preco * (1 - (0.05 * p)));
                }
            }

            if (produtosDisponiveis.get(i).tipo == 2 && produtosDisponiveis.get(i).getPeso() >= 15) preco += 10 * qt;

            if (produtosDisponiveis.get(i).promo.tipo == 0) {
                if (existe[0] == 0) Carrinho.add(new Compra(produtosDisponiveis.get(i).nome, qt, preco, false));
                else {
                    Carrinho.get(existe[1]).setQuantidade(Carrinho.get(existe[1]).quantidade + qt);
                    Carrinho.get(existe[1]).setPreco(Carrinho.get(existe[1]).preco + preco);
                }
            } else if (produtosDisponiveis.get(i).promo.tipo == 1) {
                if (existe[0] == 0) Carrinho.add(new Compra(produtosDisponiveis.get(i).nome, qt, preco, true));
                else {
                    Carrinho.get(existe[1]).setQuantidade(qt);
                    Carrinho.get(existe[1]).setPreco(preco);
                }
            } else if (produtosDisponiveis.get(i).promo.tipo == 2) {
                if (existe[0] == 0) Carrinho.add(new Compra(produtosDisponiveis.get(i).nome, qt, preco, true));
                else {
                    Carrinho.get(existe[1]).setQuantidade(qt);
                    Carrinho.get(existe[1]).setPreco(preco);
                }
            }
            produtosDisponiveis.get(i).stock -= q;
            if (produtosDisponiveis.get(i).stock == 0) produtosDisponiveis.remove(i);


            System.out.println("\nPreço final: " + String.format("%.2f", preco) + "€");
            System.out.println("Compra efetuada com sucesso.\n");
            if (produtosDisponiveis.size() == 0) {
                System.out.println("Não existem mais produtos disponíveis!\n");
                recibo(frequente, preco);
            } else {
                int escolha;
                Scanner stdin = new Scanner(System.in);
                System.out.println("MENU---------------------------------------------------");
                System.out.println("1 - Continuar a comprar");
                System.out.println("0 - Voltar ao menu inicial");
                escolha = stdin.nextInt();
                System.out.println("--------------------------------------------------------\n");
                switch (escolha) {
                    case 1 -> comprar(frequente);
                    case 0 -> recibo(frequente, preco);
                }
            }
        }
    }

    /**
     * Método que gera o recibo associado a uma compra
     * Se o Cliente não for frequente, acresce 20€ ao preço da compra
     * Se o Cliente for frequente mas o preço da compra for inferior a 40€, é acrescentada uma taxa de 15€ ao preço final
     * Adiciona o recibo à lista de Recibos e imprime o mesmo
     * Limpa o Carrinho
     * @param frequente boolean que define se o Cliente em questão é Frequente ou Normal
     * @param preco preço da compra sem taxa de entrega
     */

    public void recibo(boolean frequente, float preco) {
        int precot = 0;
        if (!frequente) precot += 20;
        else if (preco <= 40) precot += 15;
        Recibo recibo = new Recibo();
        recibo.Compras.addAll(Carrinho);
        for (Compra c : Carrinho) {
            precot += c.preco;
        }
        recibo.setPrecot(precot);
        Recibos.add(recibo);
        System.out.println("Recibo: (Quant / Produto / Preço)");
        recibo.tostring();
        Carrinho.clear();
    }

    /**
     * Método que apresenta a listagem de todos os produtos disponíveis para venda
     */

    public void listaprodutosDisponiveis() {
        int k = 0;
        for (Produto p : produtosDisponiveis) {
            System.out.println("" + k + ") " + p + "\n");
            k++;
        }
    }

//    public void listaCompras() {
//        if (Carrinho.size() == 0) System.out.println("Não existem produtos no carrinho.");
//        for (Compra c : Carrinho) {
//            System.out.println("" + c.quantidade + " " + c.nome + " " + String.format("%.2f", c.preco));
//        }
//    }

    /**
     * Método que apresenta a listagem de todos os recibos
     */

    public void listaRecibos() {
        System.out.println("Lista de recibos:\n");
        int k = 1;
        for (Recibo r : Recibos) {
            System.out.println("Recibo " + k + ":");
            r.tostring();
            System.out.print("\n");
            k++;
        }
    }

    /**
     * Método que permite ao utilizador alterar a data
     */

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