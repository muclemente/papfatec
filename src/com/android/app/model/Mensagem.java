package com.android.app.model;


public class Mensagem {
	private int Codigo, CodigoEvento, CodigoUsuario;
	private String Conteudo;
	
	public Mensagem(int codigo, int codigoEvento, int codigoUsuario, String conteudo) {
		Codigo = codigo;
		CodigoEvento = codigoEvento;
		CodigoUsuario = codigoUsuario;
		Conteudo = conteudo;
	}
	
	public Mensagem(int codigoEvento, int codigoUsuario, String conteudo) {
		CodigoEvento = codigoEvento;
		CodigoUsuario = codigoUsuario;
		Conteudo = conteudo;
	}

	public String getConteudo() {
		return Conteudo;
	}

	public void setConteudo(String conteudo) {
		Conteudo = conteudo;
	}

	public int getCodigo() {
		return Codigo;
	}

	public int getCodigoEvento() {
		return CodigoEvento;
	}

	public int getCodigoUsuario() {
		return CodigoUsuario;
	}
	
	
}
