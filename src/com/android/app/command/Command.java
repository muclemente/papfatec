package com.android.app.command;

import java.io.IOException;
import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Command {
	private ArrayList<Object []> params = new ArrayList<Object []>();
	private Object [] result = new Object[3];
	
	private int object = 0, msg = 1, isboolean = 2;
	private int pTitle = 0, pValue = 1;
	
	public AlertDialog showDialog(Context screen,String msg) {
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
	
	public void clearParams (){
		params.clear();
	}	
	
	public void setParams (String title, Object value){
		Object [] args = new Object [2];
		
		args[pTitle] = title;
		args[pValue] = value;
		
		params.add(args);
	}
	
	public String getResult_Msg (){
		return (result[msg].toString());
	}
	
	public Object getResult_Obejct (){
		if(result[object] != null)
			return result[object];
		else
			return new String("conexao");
	}	
	
	
	public Object [] callWebService(String ip,String action){
		String url = "http://"+ip+":8080/axis/Service.jws";
				
		try {
        	SoapObject request = new SoapObject(url, action);
        	
        	for(int i=0; i < params.size(); i++){        		
        		request.addProperty(params.get(i)[0].toString(), params.get(i)[1]);
        	}

        	HttpTransportSE ht = new HttpTransportSE(url);
        	
        	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        	envelope.setOutputSoapObject(request);         
        
			ht.call("Service", envelope);
			result[object] = envelope.getResponse();
			
			result[msg] = "Operação Realizada com Sucesso.";
		} catch (IOException e) {
			result[msg] = e.toString();
		} catch (XmlPullParserException e) {
			result[msg] = e.toString();
		} catch (Exception e) {
			result[msg] = e.toString();
		}
		
		if (result[msg].equals("Operação Realizada com Sucesso.")){
			result[isboolean] = true;
			return (result);
		}else{
			result[isboolean] = false;
			return (result);
		}
	}
}
