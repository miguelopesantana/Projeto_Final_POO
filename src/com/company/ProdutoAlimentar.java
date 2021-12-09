package com.company;

import java.io.Serializable;

/**
 * Classe que caracteriza um Produto Alimentar
 * @author Guilherme Faria e Miguel Santana
 */


public class ProdutoAlimentar extends Produto implements Serializable {
	protected int calorias;
	protected int gordura;

	/**
	 * Construtor
	 * @param tipo tipo do Produto
	 * @param indentificador identificador do produto
	 * @param nome nome do produto
	 * @param preco preço unitário do produto
	 * @param stock quantidade de produtos, de cada tipo, disponíveis (stock disponível)
	 * @param promo promoção associada ao produto, caso haja alguma
	 * @param calorias número de calorias do produto alimentar
	 * @param gordura percentagem de gordura do produto alimentar
	 */

	public ProdutoAlimentar(int tipo, int indentificador, String nome, float preco, int stock, Promocao promo, int calorias, int gordura) {
		super(tipo, indentificador, nome, preco, stock, promo);
		this.calorias = calorias;
		this.gordura = gordura;
	}

	protected int getPeso() {
		return 0;
	}

	/**
	 * Método que permite imprimir as características de um ProdutoAlimentar
	 * @return uma string com todas as características da Classe ProdutoAlimentar
	 */

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Calorias: " + calorias + " Kcal  Gordura: " + gordura + "%\n" +
				toStringPromo(promo.tipo);
	}
}
