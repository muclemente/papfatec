package com.android.app.command;

import java.io.IOException;
import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.android.app.Utilidades;

public class Transacao {
	private ArrayList<Object []> params = new ArrayList<Object []>();
	protected String Mensagem = null;
	public boolean Conclusao = false;
	public Object Resultado;
	
	public void clearParams() {
		params.clear();
	}
	
	public void setParams (String titulo, Object valor){
		Object [] parametro = new Object [2];
		parametro[Utilidades.CONSTANTE_TITULO] = titulo;
		parametro[Utilidades.CONSTANTE_VALOR] = valor;
		params.add(parametro);
	}
	
	public Object getResultado() {
		return Resultado;
	}
	
	public String getMensagem () {
		return Mensagem;
	}
	
	public Object callWebService(String ip, String Action){
		String url = "http://"+ip+":8080/axis/handlers/Service.jws";
		try {
        	SoapObject request = new SoapObject(url, Action);
        	for(int i=0; i < params.size(); i++){        		
        		request.addProperty(params.get(i)[0].toString(), params.get(i)[1]);
        	}
        	HttpTransportSE ht = new HttpTransportSE(url);
        	
        	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        	envelope.setOutputSoapObject(request);         
        
			ht.call("Service", envelope);
			Resultado = envelope.getResponse();
			
			Mensagem = "Operação realizada com sucesso.";
			Conclusao = true;
		} catch (IOException e) {
			Mensagem = e.toString();
			Conclusao = false;
		} catch (XmlPullParserException e) {
			Mensagem = e.toString();
			Conclusao = false;
		} catch (Exception e) {
			Mensagem = e.toString();
			Conclusao = false;
		}
		
		return Resultado;
	}
}
