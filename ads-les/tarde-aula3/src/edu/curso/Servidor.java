package edu.curso;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Servidor {
	public static void main(String[] args) {
		try {
			System.out.println("Servidor Iniciado");
			ServerSocket srv = 
					new ServerSocket(15678);
			System.out.println(
					"Porta reservada, " +
					"aguardando comunicação do cliente");
			Socket s = srv.accept();
			OutputStream out = s.getOutputStream();
			InputStream in = s.getInputStream();
			byte[] bytes = 
				"Bem vindo ao servidor\r\n".getBytes();
			out.write( bytes );
			out.flush();
			int i = 0;
			while(i != 27) { 
				if (System.in.available() > 0) { 
					i = System.in.read();
					out.write( i );
					out.flush();
				}
				if (in.available() > 0) {
					char c = (char)in.read();
					System.out.print(c);
				}
			}
			
			System.out.println("Cliente conectado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Servidor Finalizado");
	}
}
