package com.romarini.sender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.romarini.model.Pedido;

public class XMLSender {
	
	public static void main(String[] args) {
		
		Pedido p = new Pedido(1, "Fulano", "Ciclano", 10.0);
				
		try {
//			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Pedido.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			jaxbMarshaller.marshal(p, file);
			jaxbMarshaller.marshal(p, System.out);
			
			//enviando arquivo
			URL url = new URL("http://localhost:8080/RestfulWS/processXML");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/xml");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			
			StringWriter writer = new StringWriter();
			jaxbMarshaller.marshal(p, writer);
			out.write(writer.toString());
			out.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 
			while (in.readLine() != null) {
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
