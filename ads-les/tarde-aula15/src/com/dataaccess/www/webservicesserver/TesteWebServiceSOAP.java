package com.dataaccess.www.webservicesserver;

public class TesteWebServiceSOAP {
	
	public static void main(String[] args) throws Exception {
		TextCasingSoapTypeProxy tc 
			= new TextCasingSoapTypeProxy();
		
		String texto = tc.invertStringCase("texto em MAIUSCULO");
		System.out.println(texto);
	}

}
