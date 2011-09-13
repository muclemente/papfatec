package com.android.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.android.app.command.Command;

public class AppActivity extends Activity implements OnClickListener {
	private Command com = new Command();
	
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
			dialog.show();
			
			com.clearParams();
			com.setParams("Usuario", strUsuario);
			com.setParams("Senha", strSenha);
			Object resultado[];
			resultado = com.callWebService("192.168.42.215", "login");
			/*if(resultado[0].equals("null")) {
				statusMsg = "E-mail ou senha incorretos.";
			} else {
				statusMsg = "Conectado!";
			}
			*/
			dialog.setMessage(com.getResult_Msg().toString());
			
			
		} else if(botao.getId() == R.btn.cadastro) {
			Intent i = new Intent(AppActivity.this, CadastroActivity.class);
			startActivity(i);
		}
	}
}