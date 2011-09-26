package com.android.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.app.command.Cadastro;
import com.android.app.model.Usuario;

public class CadastroActivity extends Activity implements OnClickListener {
	private Cadastro cadastro = new Cadastro();
	Usuario user;
	public static boolean DEBUG = true;
	EditText primeiroNome;
	EditText ultimoNome;
	EditText email;
	EditText senha;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro);
		
		Button btnEnviar = (Button) findViewById(R.btn.cadastro_enviar);
		btnEnviar.setOnClickListener(this);
		email = (EditText) findViewById(R.edt.cadastro_usuario_email);
		email.setText("muclemente@gmail.com");
	}

	@Override
	public void onClick(View botao) {
		cadastro.clearParams();
		//Cria instâncias dos inputs e busca seus conteúdos pelas suas IDs em /gen/R/edt
		primeiroNome = (EditText) findViewById(R.edt.cadastro_usuario_primeiro_nome);
		ultimoNome = (EditText) findViewById(R.edt.cadastro_usuario_ultimo_nome);
		email = (EditText) findViewById(R.edt.cadastro_usuario_email);
		senha = (EditText) findViewById(R.edt.cadastro_usuario_senha);
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
			Utilidades.makeDialog(botao.getContext(), "O primeiro nome não pode estar vazio.").show();
			return;
		} else if(ulNome.equals("")) {
			Utilidades.makeDialog(botao.getContext(), "O último nome não pode estar vazio.").show();
			return;
		} else if(!matchFound) {
			Utilidades.makeDialog(botao.getContext(), "Você deve inserir um e-mail válido.").show();
			return;
		} else if(strSenha.length() < 6) {
			Utilidades.makeDialog(botao.getContext(), "Sua senha deve conter 6 ou mais caracteres.").show();
			return;
		}
		
		//Busca o número de telefone do aparelho
		TelephonyManager tMgr;
		tMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		String numTelefone = tMgr.getLine1Number();
		
		//Insere os parâmetros no envelope do SOAP
		cadastro.setParams("PrimeiroNome", prNome);
		cadastro.setParams("UltimoNome", ulNome);
		cadastro.setParams("Email", strEmail);
		cadastro.setParams("Senha", strSenha);
		cadastro.setParams("Telefone", numTelefone);
		
		//Faz a chamada para o Service.wjs
		cadastro.callWebService(this.getString(R.string.ip), "insertUser");
	
		//Exibe o resultado
		Utilidades.makeDialog(this, cadastro.getMensagem()).show();
		//Finaliza esta atividade e volta para a tela principal
		//finish();
	}
	
}
