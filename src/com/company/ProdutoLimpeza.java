package com.company;

/**
 * Classe que caracteriza um Produto de Limpeza
 * @author Guilherme Faria e Miguel Santana
 */

public class ProdutoLimpeza extends Produto {
	protected int toxicidade;

	/**
	 * Construtor
 	 * @param tipo tipo do Produto (Alimentar, Limpeza ou Mobiliário)
	 * @param indentificador identificador do produto
	 * @param nome nome do produto
	 * @param preco preço unitário do produto
	 * @param stock quantidade de produtos, de cada tipo, disponíveis (stock disponível)
	 * @param promo promoção associada ao produto, caso haja alguma
	 * @param toxicidade índice de toxicidade do produto
	 */

	public ProdutoLimpeza(int tipo, int indentificador, String nome, float preco, int stock, Promocao promo, int toxicidade) {
		super(tipo, indentificador, nome, preco, stock, promo);
		this.toxicidade = toxicidade;
	}

	public int getPeso() {
		return 0;
	}

	/**
	 * Método que permite imprimir as características de um Produto de Limpeza
	 * @return uma string com todas as características da Classe ProdutoLimpeza
	 */

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Toxicidade: " + toxicidade + "\n" +
				toStringPromo(promo.tipo);
	}
}
