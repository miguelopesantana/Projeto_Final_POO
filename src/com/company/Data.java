package com.company;

import java.io.Serializable;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe que caracteriza a Data
 * @author Guilherme Faria e Miguel Santana
 */

public class Data implements Serializable {
    protected int dia;
    protected int mes;
    protected int ano;

    /**
     * Construtor
     * @param dia dia em que está a ser efetuada a compra
     * @param mes mês em que está a ser efetuada a compra
     * @param ano ano em que está a ser efetuada a compra
     */

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data(){}

    /**
     * Método que permite definir a data de acordo com a escolha do cliente
     * @return data introduzida pelo cliente
     */

    protected Data setData() {
        try {
            System.out.println("Introduza a data:");
            System.out.print("Dia: ");
            Scanner sc1 = new Scanner(System.in);
            int dia = sc1.nextInt();
            System.out.print("Mês: ");
            Scanner sc2 = new Scanner(System.in);
            int mes = sc2.nextInt();
            System.out.print("Ano: ");
            Scanner sc3 = new Scanner(System.in);
            int ano = sc3.nextInt();
            while (!verificaData(dia, mes, ano)) {
                System.out.print("\nInsira a data:\n ");
                System.out.print("Dia: ");
                Scanner sc4 = new Scanner(System.in);
                dia = sc4.nextInt();
                System.out.print("Mês: ");
                Scanner sc5 = new Scanner(System.in);
                mes = sc5.nextInt();
                System.out.printf("Ano: ");
                Scanner sc6 = new Scanner(System.in);
                ano = sc6.nextInt();
            }
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
            return new Data(dia, mes, ano);
        } catch (InputMismatchException ex) {
            System.out.println("Data inválida. Os únicos caracteres aceites são algarismos.");
            setData();
        }
        return null;
    }

    /**
     * Método que permite verificar se a data introduzida pelo utilizador é válida
     * @param dia dia introduzido pelo Cliente
     * @param mes mês introduzido pelo Cliente
     * @param ano ano introduzido pelo Cliente
     * @return true se a data introduzida for válida, false caso não seja válida
     */

    private boolean verificaData(int dia, int mes, int ano) {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        if (dia < 1) {
            System.out.println("Dia inválido");
            return false;
        }

        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido.");
            return false;
        }

        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 31) {
            System.out.println("Data inválida. " + meses[mes] + " tem apenas 31 dias");
            return false;
        } else if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && dia > 30) {
            System.out.println("Data inválida. " + meses[mes] + " tem apenas 30 dias");
            return false;
        }

        if (Year.isLeap(ano)) {
            if (mes == 2 && dia > 29) {
                System.out.println("Data inválida. Fevereiro em anos comuns tem apenas 28 dias");
                return false;
            }
        }
        if (!Year.isLeap(ano)) {
            if (mes == 2 && dia > 28) {
                System.out.println("Data inválida. Fevereiro em anos bissextos tem apenas 29 dias");
                return false;
            }
        }

        System.out.println("Data introduzida:  " + dia + " / " + mes + " / " + ano + ".\n");
        return true;
    }
}
