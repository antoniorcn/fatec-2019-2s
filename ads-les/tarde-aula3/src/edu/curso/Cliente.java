package edu.curso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
			try (
				Socket cliente = new Socket("127.0.0.1", 15678)
				) {
				System.out.println("Cliente iniciado");
				
				System.out.println("Conectado no servidor");
				InputStream in = cliente.getInputStream();
				OutputStream out = cliente.getOutputStream();
				InputStreamReader inr = new InputStreamReader(System.in);
				BufferedReader bfr = new BufferedReader(inr);
				while( cliente.isConnected()) { 
					if (in.available() > 0) { 
						char c = (char)in.read();
						System.out.print(c);
					}
					if (bfr.ready()) { 
						String linha = bfr.readLine() + "\r\n";
						out.write(linha.getBytes());
						out.flush();
					}
				}
				System.out.println("Cliente finalizado");
			} catch (IOException e) {
				e.printStackTrace();
			}


	}

}
