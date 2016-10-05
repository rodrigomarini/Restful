package com.romarini.sender;
 
import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
 
import org.json.JSONObject;

 /**
  * Classe utilitária para enviar um JSON via HTTP Post
  * 
  * @author rodrigomarini
  *
  */
public class JSonSender {
	
	public static void main(String[] args) {
		String string = "";
		
		try {
			// lendo o json no file system
			InputStream inputStream = new FileInputStream("/Users/rodrigomarini/Documents/workspace/RestfulWS/src/main/webapp/json.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader br = new BufferedReader(inputStreamReader);
			String line;
			while ((line = br.readLine()) != null) {
				string += line + "\n";
			}
 
			// criando e enviando um objeto json
			JSONObject jsonObject = new JSONObject(string);
			
			System.out.println(jsonObject);
 
			try {
				URL url = new URL("http://localhost:8080/RestfulWS/processJson");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while (in.readLine() != null) {
				}
				in.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}