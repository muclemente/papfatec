package com.android.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.app.command.Command;
import com.android.app.model.Usuario;

public class AppActivity extends Activity implements OnClickListener, OnDismissListener {
	private Command com = new Command();
	Usuario logon;
	Boolean sucesso;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btnConnect = (Button) findViewById(R.btn.connect);
		btnConnect.setOnClickListener(this);
		Button btnCadastro = (Button) findViewById(R.btn.cadastro);
		btnCadastro.setOnClickListener(this);
		
		EditText boxUsuario = (EditText) findViewById(R.edt.conectar_usuario);
		EditText boxSenha = (EditText) findViewById(R.edt.conectar_senha);
		boxUsuario.setText("muclemente@gmail.com");
		boxSenha.setText("123456");
	}

	@Override
	public void onClick(View botao) {
		if(botao.getId() == R.btn.connect) {


			EditText boxUsuario = (EditText) findViewById(R.edt.conectar_usuario);
			EditText boxSenha = (EditText) findViewById(R.edt.conectar_senha);
			String strUsuario = boxUsuario.getText().toString();
			String strSenha = boxSenha.getText().toString();
			
			Pattern p = Pattern.compile(".+@.+\\.[a-z]+");  
		    Matcher m = p.matcher(strUsuario);  
		    boolean matchFound = m.matches();  
			String statusMsg = "";
		    if(!matchFound) {
				statusMsg = "E-mail inválido.";
			} else {
				statusMsg = "Conectando...";
			}
		    
		    
			AlertDialog dialog = com.showDialog(botao.getContext(), statusMsg);
			dialog.setOnDismissListener(this);
			dialog.show();
			
			com.clearParams();
			com.setParams("Usuario", strUsuario);
			com.setParams("Senha", strSenha);
			
			com.callWebService(this.getString(R.string.ip), "login");
			String lineResult = com.getResult_Obejct().toString();
			lineResult = lineResult.substring(1, lineResult.length()-1);
			String[] resultado = lineResult.split(", ");
			
			//0 = Codigo, 1 = PrimeiroNome, 2, = UltimoNome, 3 = Email, 4 = Saldo, 5 = Senha 
			if(resultado[0].equals("null")) {
				statusMsg = "E-mail ou senha incorretos.";
				sucesso = false;
			} else if(resultado[0].equals("conexao")) {
				statusMsg = "Falha na conexão.";
				sucesso = false;
			} else {
				statusMsg = "Conectado com sucesso.";
				//Converte e cria uma instância do usuário online
				logon = new Usuario(Integer.parseInt(resultado[0]),
						resultado[1], 
						resultado[2],
						resultado[3],
						resultado[5],
						Float.parseFloat(resultado[4])
						);
				sucesso = true;
			}
			dialog.setMessage(statusMsg);

			
		} else if(botao.getId() == R.btn.cadastro) {
			Intent i = new Intent(AppActivity.this, CadastroActivity.class);
			startActivity(i);
		}
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		if(sucesso) {
			Intent i = new Intent(AppActivity.this, Dashboard.class);
			startActivity(i);
		}
		
	}
}