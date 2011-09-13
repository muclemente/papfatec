package com.android.app.model;

import java.io.Serializable;

public class Participacao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4322630279440520879L;
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
