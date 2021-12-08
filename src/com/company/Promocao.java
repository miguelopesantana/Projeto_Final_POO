package com.company;

import java.io.Serializable;

/**
 * Classe que caracteriza uma Promoção
 * @author Guilherme Faria e Miguel Santana
 */

public class Promocao implements Serializable {
    protected int tipo;
    protected String[] datai;
    protected String[] dataf;

    /**
     * Construtor
     * @param tipo corresponde ao tipo de promoção (Pague-Menos ou Leve-4-Pague3)
     * @param datai data de ínicio da promoção
     * @param dataf data do fim da promoção
     */

    public Promocao(int tipo, String[] datai, String[] dataf) {
        this.tipo = tipo;
        this.datai = datai;
        this.dataf = dataf;
    }
}
