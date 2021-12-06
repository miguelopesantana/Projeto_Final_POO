package com.company;

abstract class Produto {
	int id;
	String nome;
	int preco;
	int stock;
	
	public Produto(int id, String nome, int preco, int stock) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.stock = stock;
	}
	
}
