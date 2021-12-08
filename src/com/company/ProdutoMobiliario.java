package com.company;

import java.io.Serializable;

/**
 * Classe que caracteriza um Produto de Mobiliário
 * @author Guilherme Faria e Miguel Santana
 */

public class ProdutoMobiliario extends Produto implements Serializable{
	protected int peso;
	protected int dimensao;

	/**
	 * Construtor
	 * @param tipo tipo do Produto (Alimentar, Limpeza ou Mobiliário)
	 * @param indentificador identificador do produto
	 * @param nome nome do produto
	 * @param preco preço unitário do produto
	 * @param stock quantidade de produtos, de cada tipo, disponíveis (stock disponível)
	 * @param promo promoção associada ao produto, caso haja alguma
	 * @param peso peso de cada produto de mobiliário
	 * @param larg largura do produto de mobiliário
	 * @param prof profundidade do produto de mobiliário
	 * @param alt altura do produto de mobiliário
	 */

	public ProdutoMobiliario(int tipo, int indentificador, String nome, float preco, int stock, Promocao promo, int peso, int larg, int prof, int alt) {
		super(tipo, indentificador, nome, preco, stock, promo);
		this.peso = peso;
		this.dimensao = larg*prof*alt;
	}

	public int getPeso() {
		return peso;
	}

	/**
	 * Método que permite imprimir as características de um Produto de Mobiliário
	 * @return uma string com todas as características da Classe ProdutoMobiliário
	 */

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Peso: " + peso + "Kg Dimensão: " + dimensao + "\n" +
				toStringPromo(promo.tipo);
	}
}
