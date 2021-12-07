package com.company;

public class Cliente {
	String nome;
	String morada;
	String email;
	int num_telemovel;
	String data_nasc;

	/**
	 * Construtor
	 * @param nome corresponde ao nome do Cliente
	 * @param morada correspondente à morada do cliente
	 * @param email  corresponde ao email do Cliente
	 * @param num_telemovel corresponde ao número de telemóvel do Cliente
	 * @param data_nasc corresponde à data de nascimento do Cliente
	 */

	public Cliente(String nome, String morada, String email, int num_telemovel, String data_nasc) {
		this.nome = nome;
		this.morada = morada;
		this.email = email;
		this.num_telemovel = num_telemovel;
		this.data_nasc = data_nasc;
	}
}
