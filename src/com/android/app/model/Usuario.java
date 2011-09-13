package com.android.app.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -401603698374845308L;
	int id;
	String primeiroNome, ultimoNome, email, senha;
	float saldo;
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public Usuario(int id, String firsName, String lastName, String email,
			String password, float balance) {
		this.id = id;
		this.primeiroNome = firsName;
		this.ultimoNome = lastName;
		this.email = email;
		this.senha = password;
		this.saldo = balance;
	}
	
	public Usuario(String firsName, String lastName, String email,
			String password) {
		this.primeiroNome = firsName;
		this.ultimoNome = lastName;
		this.email = email;
		this.senha = password;
	}

	
}
