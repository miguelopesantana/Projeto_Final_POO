package com.company;

public class ProdutoMobiliario extends Produto{
	int peso;
	int dimensao;

	public ProdutoMobiliario(int tipo, int indentificador, String nome, float preco, int stock, Promocao promo, int peso, int larg, int prof, int alt) {
		super(tipo, indentificador, nome, preco, stock, promo);
		this.peso = peso;
		this.dimensao = larg*prof*alt;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" +
				"Peso: " + peso + "Kg Dimensão: " + dimensao + "\n" +
				toStringPromo(promo.tipo);
	}
}
