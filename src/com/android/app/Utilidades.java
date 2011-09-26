package com.android.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public final class Utilidades {
	//Constantes para a classe de Transacao
	public static int CONSTANTE_TITULO = 0;
	public static int CONSTANTE_VALOR = 1;
	public static boolean DEBUG = true;
	
	//Criação de diálogos genéricos
	public static AlertDialog makeDialog(Context screen, String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(screen);
		builder.setMessage(msg).setCancelable(false).setNeutralButton(
				"OK", 
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
	            }
			});
		AlertDialog alert = builder.create();
		return (alert);
	}
	
}
