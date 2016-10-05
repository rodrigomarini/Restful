package com.romarini.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pedido {
	
	private int id;
	private String vendedor;
	private String cliente;
	private Double valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Pedido(int id, String vendedor, String cliente, Double valor) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.valor = valor;
	}
	
	public Pedido(){
		super();
	}

}
