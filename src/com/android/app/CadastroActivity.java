package com.android.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.app.command.Command;
import com.android.app.model.Usuario;

public class CadastroActivity extends Activity implements OnClickListener {
	private Command com = new Command();
	Usuario user;
	public static boolean DEBUG = true;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);
		
		Button btnEnviar = (Button) findViewById(R.btn.cadastro_enviar);
		btnEnviar.setOnClickListener(this);
	}

	@Override
	public void onClick(View botao) {
		com.clearParams();
		//Cria instâncias dos inputs e busca seus conteúdos pelas suas IDs em /gen/R/edt
		EditText primeiroNome = (EditText) findViewById(R.edt.cadastro_usuario_primeiro_nome);
		EditText ultimoNome = (EditText) findViewById(R.edt.cadastro_usuario_ultimo_nome);
		EditText email = (EditText) findViewById(R.edt.cadastro_usuario_email);
		EditText senha = (EditText) findViewById(R.edt.cadastro_usuario_senha);
		//Converte os valores dentro dos inputs para texto
		String prNome = primeiroNome.getText().toString();
		String ulNome = ultimoNome.getText().toString();
		String strEmail = email.getText().toString();
		String strSenha = senha.getText().toString();
		
		//Faz a verficiação de dados 
	      Pattern p = Pattern.compile(".+@.+\\.[a-z]+");  
	      Matcher m = p.matcher(strEmail);  
	      boolean matchFound = m.matches();  
		if(prNome.equals("")) {
			showDialog(botao.getContext(), "O primeiro nome não pode estar vazio.").show();
			return;
		} else if(ulNome.equals("")) {
			showDialog(botao.getContext(), "O último nome não pode estar vazio.").show();
			return;
		} else if(!matchFound) {
			showDialog(botao.getContext(), "Você deve inserir um e-mail válido.").show();
			return;
		} else if(strSenha.length() < 6) {
			showDialog(botao.getContext(), "Sua senha deve conter 6 ou mais caracteres.").show();
			return;
		}
		
		//Busca o número de telefone do aparelho
		TelephonyManager tMgr;
		tMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		String numTelefone = tMgr.getLine1Number();
		
		//Insere os parâmetros no envelope do SOAP
		com.setParams("PrimeiroNome", prNome);
		com.setParams("UltimoNome", ulNome);
		com.setParams("Email", strEmail);
		com.setParams("Senha", strSenha);
		com.setParams("Telefone", numTelefone);
		
		//Faz a chamada para o Service.wjs
		Object resultado = com.callWebService("192.168.42.215", "insertUser");
		String statusMsg = null;
		
		//Captura e analisa o resultado
		if(!resultado.equals("sucesso")) {
		} else {
			statusMsg = "Operação concluída.";
		}
		
		//Exibe o resultado
		showDialog(botao.getContext(), statusMsg).show();
		
		//Finaliza esta atividade e volta para a tela principal
		finish();
	}
	
	public AlertDialog showDialog(Context screen, String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(screen);
		builder.setMessage(msg)
			.setCancelable(false)
			.setNeutralButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
	            }
			});
		AlertDialog alert = builder.create();
		return (alert);
	}
	
}
