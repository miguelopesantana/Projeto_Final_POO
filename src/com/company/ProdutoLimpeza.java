package com.company;

public class ProdutoLimpeza extends Produto {
	int toxicidade;

	public ProdutoLimpeza(int identificador, String nome, int preco, int stock, int toxicidade) {
		super(identificador, nome, preco, stock);
		this.toxicidade = toxicidade;
	}
	
	

}
