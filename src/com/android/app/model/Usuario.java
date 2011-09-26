package com.android.app.model;


public class Usuario {
	boolean online;
	int id;
	String primeiroNome, ultimoNome, email, senha;
	float saldo;
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public boolean isOnline() {
		return online;
	}
	
	public void setOnline(boolean value) {
		online = value;
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
		this.online = true;
	}
	
	public Usuario(String firsName, String lastName, String email,
			String password) {
		this.primeiroNome = firsName;
		this.ultimoNome = lastName;
		this.email = email;
		this.senha = password;
		this.online = true;
	}

	
}
