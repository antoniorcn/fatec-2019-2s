package com.dataaccess.www.webservicesserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
public class TesteWebServiceREST {
	
	public static void main(String[] args) throws IOException, Exception {
		String cep = "06764045";
		URL url = new URL(
				"https://buscarcep.com.br/?cep=" + cep + "&formato=string&chave=Chave_Gratuita_BuscarCep");
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();
		StringBuffer sb = new StringBuffer();
		while (is.available() > 0){
			int b = is.read();
			sb.append((char)b);
		}
		String[] elementos = sb.toString().split("&");
		Map<String, String> map = new HashMap<>();
		for (String e : elementos) { 
			String[] chaveEValor = e.split("=");
			if (chaveEValor.length > 1) { 
				System.out.println(chaveEValor[0] + " -- " + chaveEValor[1]);
				map.put(chaveEValor[0], chaveEValor[1]);
			}
		}
	}
}
