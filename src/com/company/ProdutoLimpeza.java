package com.company;

public class ProdutoLimpeza extends Produto {
	int toxicidade;

	public ProdutoLimpeza(int tipo, int indentificador, String nome, float preco, int stock, Promocao promo, int toxicidade) {
		super(tipo, indentificador, nome, preco, stock, promo);
		this.toxicidade = toxicidade;
	}

	public int getPeso() {
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Toxicidade: " + toxicidade + "\n" +
				toStringPromo(promo.tipo);
	}
}
