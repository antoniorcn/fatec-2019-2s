package edu.curso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class JobConversa implements Runnable {
	private Socket cliente;
	
	public JobConversa(Socket s) { 
		this.cliente = s;
	}
	
	@Override
	public void run() {
		try {
			OutputStream out = cliente.getOutputStream();
			InputStream in = cliente.getInputStream();
			byte[] bytes = 
				"Bem vindo ao servidor\r\n".getBytes();
			out.write( bytes );
			out.flush();
			System.out.println("Cliente conectado");
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader bfr = new BufferedReader(reader);
			String linha = "";
			while(!linha.contains("SAIR")) { 
				if (bfr.ready()) { 
					linha = bfr.readLine() + "\r\n";
					out.write( linha.getBytes() );
					out.flush();
				}
				if (in.available() > 0) {
					char c = (char)in.read();
					System.out.print(c);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
