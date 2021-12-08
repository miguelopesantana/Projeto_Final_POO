package com.company;

import java.io.Serializable;

/**
 * Classe que caracteriza um Cliente
 * @author Guilherme Faria e Miguel Santana
 */

public class Cliente {
	protected String nome;
	protected String morada;
	protected String email;
	protected int num_telemovel;
	protected String data_nasc;

	/**
	 * Construtor
	 * @param nome nome do Cliente
	 * @param morada morada do Cliente
	 * @param email  email do Cliente
	 * @param num_telemovel número de telemóvel do Cliente
	 * @param data_nasc data de nascimento do Cliente
	 */

	public Cliente(String nome, String morada, String email, int num_telemovel, String data_nasc) {
		this.nome = nome;
		this.morada = morada;
		this.email = email;
		this.num_telemovel = num_telemovel;
		this.data_nasc = data_nasc;
	}

	@Override
	public String toString() {
		return nome + ';' +
				"\n, morada='" + morada + '\'' +
				"\n, email='" + email + '\'' +
				"\n, num_telemovel=" + num_telemovel +
				"\n, data_nasc='" + data_nasc + '\'' +
				'}';
	}
}
