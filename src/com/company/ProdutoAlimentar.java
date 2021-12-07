package com.company;

public class ProdutoAlimentar extends Produto{
	int calorias;
	int gordura;

	/**
	 * Construtor
	 * @param tipo corresponde ao tipo do Produto
	 * @param indentificador corresponde ao identificador do produto
	 * @param nome corresponde ao nome do produto
	 * @param preco corresponde ao preço do produto
	 * @param stock corresponde à quantidade de produtos, de cada tipo, disponíveis (stock disponível)
	 * @param promo corresponde à promoção associada ao produto, caso haja alguma
	 * @param calorias corresponde ao número de calorias do produto alimentar
	 * @param gordura corresponde à percentagem de gordura do produto alimentar
	 */

	public ProdutoAlimentar(int tipo, int indentificador, String nome, float preco, int stock, Promocao promo, int calorias, int gordura) {
		super(tipo, indentificador, nome, preco, stock, promo);
		this.calorias = calorias;
		this.gordura = gordura;
	}

	public int getPeso() {
		return 0;
	}

	/**
	 * Método que permite imprimir as características de um ProdutoAlimentar
	 * @return retorna uma string com todas as características da Classe ProdutoAlimentar
	 */

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Calorias: " + calorias + " Kcal  Gordura: " + gordura + "%\n" +
				toStringPromo(promo.tipo);
	}
}
