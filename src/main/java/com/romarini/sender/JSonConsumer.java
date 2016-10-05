package com.romarini.sender;

import java.io.PrintStream;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class JSonConsumer {

	public static void main(String[] args) throws Exception {
		HttpClient httpClient = new HttpClient();

		GetMethod httpGet = new GetMethod("http://localhost:8080/RestfulWS/pedido/1");
		httpGet.addRequestHeader("Accept", "application/json");
		httpClient.executeMethod(httpGet);
		Scanner scan = new Scanner(httpGet.getResponseBodyAsStream());
		PrintStream ps = System.out;
		while (scan.hasNext()) {
			ps.println(scan.nextLine());
		}
		httpGet.releaseConnection();
	}

}
