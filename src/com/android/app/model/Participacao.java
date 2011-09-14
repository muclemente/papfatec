package com.android.app.model;


public class Participacao{
	private int CodigoUsuario, CodigoEvento;
	private boolean Pago;
	
	public Participacao(int codus, int codev) {
		CodigoUsuario = codus;
		CodigoEvento = codev;
		Pago = false;
	}

	public boolean isPago() {
		return Pago;
	}

	public void setPago(boolean pago) {
		Pago = pago;
	}

	public int getCodigoUsuario() {
		return CodigoUsuario;
	}

	public int getCodigoEvento() {
		return CodigoEvento;
	}
}
