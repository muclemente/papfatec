package com.android.app;

import java.util.LinkedHashMap;
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

import com.android.app.command.Login;
import com.android.app.model.Usuario;

public class AppActivity extends Activity implements OnClickListener, OnDismissListener {
	private Login login = new Login();
	Usuario autenticado;
	
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
		    
			AlertDialog dialog = Utilidades.makeDialog(botao.getContext(), statusMsg);
			dialog.setOnDismissListener(this);
			dialog.show();
			
			login.clearParams();
			login.setParams("Usuario", strUsuario);
			login.setParams("Senha", strSenha);
			login.callWebService(this.getString(R.string.ip), "login");
			
			LinkedHashMap<String, Object> resultado = login.getResultado();
			
			autenticado = new Usuario(
					(Integer)resultado.get("Codigo"),
					(String)resultado.get("PrimeiroNome"),
					(String)resultado.get("UltimoNome"),
					(String)resultado.get("Email"),
					(String)resultado.get("Senha"),
					(Float)resultado.get("Saldo")
					);
			
			dialog.setMessage(login.getMensagem());
			
		} else if(botao.getId() == R.btn.cadastro) {
			Intent i = new Intent(AppActivity.this, CadastroActivity.class);
			startActivity(i);
		}
	}

	@Override
	public void onDismiss(DialogInterface dialog) {
		if(login.Conclusao) {
			Intent i = new Intent(AppActivity.this, Dashboard.class);
			startActivity(i);
		}	
		
	}
}