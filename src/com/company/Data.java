package com.company;

import java.time.Year;

public class Data {
    protected int dia;
    protected int mes;
    protected int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static boolean verificaData(int dia, int mes, int ano) {
        if((mes == 4 || mes == 6 || mes == 9 || mes == 11)  && dia > 31) {
            return false;
        }
        if((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && dia > 30) {
            return false;
        }
        if(Year.isLeap(ano)) {
            if(mes == 2 && dia > 29) {
                return false;
            }
        }
        if(!Year.isLeap(ano)) {
            if(mes == 2 && dia > 28) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                '}';
    }
}
