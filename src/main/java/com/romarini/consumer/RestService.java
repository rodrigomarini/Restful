package com.romarini.consumer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 
 * Classe utilitária para consumir arquivos via rest
 * 
 * @author rodrigomarini
 *
 */
@Path("/")
public class RestService {
	
	@POST
	@Path("/processJson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response restService(InputStream incomingData) {
		
		StringBuilder content = new StringBuilder();
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			
			while ((line = in.readLine()) != null) {
				content.append(line);
			}
			
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + content.toString());
 
		// return HTTP Response 200 em caso de sucesso
		return Response.status(200).entity(content.toString()).build();
	}
	
	@POST
	@Path("/processXML")
	@Consumes(MediaType.APPLICATION_XML)
	public Response restServiceXML(InputStream incomingData) {
		
		StringBuilder content = new StringBuilder();
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			
			while ((line = in.readLine()) != null) {
				content.append(line);
			}
			
		} catch (Exception e) {
			System.out.println("Error Parsing "+e);
		}
		
		System.out.println("Data Received: " + content.toString());
		
		// return HTTP Response 200 em caso de sucesso
		return Response.status(200).entity("").build();
	}
 
	@GET
	@Path("/verify") // http://localhost:8080/RestfulWS/verify
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		String result = "Service Successfully started..";
		// retorna status 200 em caso de sucesso
		return Response.status(200).entity(result).build();
	}
 
}