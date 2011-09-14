package com.android.app.model;


public class Evento {
	
	private int Codigo, CodigoUsuario, CEP;
	private String Titulo, Data, Descricao, Endereco,
					Bairro, Numero, Cidade, Estado;
	private float ValorTotal, ValorPart, Latitude, Longitude;
	
	public Evento(int codigo, String titulo, String data, int codigoUsuario,
			float valorTotal, float valorPart, String descricao, float latitude,
			float longitude, String endereco, String bairro, String numero,
			String cidade, String estado, int cep) {
		Codigo = codigo;
		Titulo = titulo;
		Data = data;
		CodigoUsuario = codigoUsuario;
		ValorTotal = valorTotal;
		ValorPart = valorPart;
		Descricao = descricao;
		Latitude = latitude;
		Longitude = longitude;
		Endereco = endereco;
		Bairro = bairro;
		Numero = numero;
		Cidade = cidade;
		Estado = estado;
		CEP = cep;
	}
	
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int cEP) {
		CEP = cEP;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public float getLatitude() {
		return Latitude;
	}
	public void setLatitude(float latitude) {
		Latitude = latitude;
	}
	public float getLongitude() {
		return Longitude;
	}
	public void setLongitude(float longitude) {
		Longitude = longitude;
	}
	public int getCodigo() {
		return Codigo;
	}
	public int getCodigoUsuario() {
		return CodigoUsuario;
	}
	public float getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(float valorTotal) {
		ValorTotal = valorTotal;
	}
	public float getValorPart() {
		return ValorPart;
	}
	public void setValorPart(float valorPart) {
		ValorPart = valorPart;
	}

}
