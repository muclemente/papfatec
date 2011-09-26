package com.android.app.command;

import com.android.app.Utilidades;

public class Cadastro extends Transacao {
	@Override
	public Object getResultado() {
			if(Utilidades.DEBUG == false) {
				if(Resultado.equals("existe")) {
					Mensagem = "Já existe um cadastro com este e-mail.";
				} else if(!Resultado.equals("sucesso")) {
					Mensagem = "Não foi possível cadastrar.";
				} else {
					Mensagem = "Operação concluída.";
				}
			}
			return new Boolean(true);
	}

	
}