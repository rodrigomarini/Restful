package com.romarini.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.romarini.model.Pedido;

@Path("/pedido/{id}")
public class PedidoResource {
	
	@GET
	@Produces( { MediaType.APPLICATION_JSON })
	public Pedido getPedidoById(@PathParam("id") Long id) {

		//recupera do db
		Pedido pedido = new Pedido(1, "Vendedor", "Cliente", 80.00);

		return pedido;
	}
}
