package com.android.app.command;

import java.util.LinkedHashMap;

public class Login extends Transacao {
	@Override
	public LinkedHashMap<String, Object> getResultado() {
		LinkedHashMap<String, Object> resultado = new LinkedHashMap<String, Object>();
		String lineResult = Resultado.toString();
		lineResult = lineResult.substring(1, lineResult.length()-1);
		String[] stringResult = lineResult.split(", ");
		if(Conclusao) {
			if(stringResult[0].equals("null")) {
				Mensagem = "E-mail ou senha incorretos.";
				Conclusao = false;
			} else if(stringResult[0].equals("conexao")) {
				Mensagem = "Falha na conexão.";
				Conclusao = false;
			} else {
				Mensagem = "Conectado com sucesso.";
				resultado.put("Codigo", Integer.parseInt(stringResult[0]));
				resultado.put("PrimeiroNome", stringResult[1]);
				resultado.put("UltimoNome", stringResult[2]);
				resultado.put("Email", stringResult[3]);
				resultado.put("Saldo", Float.parseFloat(stringResult[4]));
				resultado.put("Senha", stringResult[5]);
			}
		}
		return resultado;
	}
}
