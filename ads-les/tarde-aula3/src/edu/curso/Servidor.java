package edu.curso;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
	public static void main(String[] args) {
		try (
			ServerSocket srv = new ServerSocket(15678)
			) {
			System.out.println("Servidor Iniciado");
			 
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
			e.printStackTrace();
		}
		System.out.println("Servidor Finalizado");
	}
}
