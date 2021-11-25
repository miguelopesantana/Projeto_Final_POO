package com.company;

public class ProdutoMobiliario extends Produto{
	int peso;
	int dimensao;
	
	public ProdutoMobiliario(int identificador, String nome, int preco, int stock, int peso, int dimensao) {
		super(identificador, nome, preco, stock);
		this.peso = peso;
		this.dimensao = dimensao;
	}

}
