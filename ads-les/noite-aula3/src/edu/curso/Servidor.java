package edu.curso;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
	public static void main(String[] args) {
		try (ServerSocket srv = new ServerSocket(15678)){
			System.out.println("Iniciando servidor");
			System.out.println("Aguardando conexão do cliente");
			Socket cli = srv.accept();
			OutputStream out = cli.getOutputStream();
			InputStream in = cli.getInputStream();
			out.write("Bem vindo ao servidor Java".getBytes());
			out.flush();
			int i = 0;
			while ((i = in.read()) != 27) { 
				System.out.print((char)i);
			}
			System.out.println("Cliente conectado");
			System.out.println("Finalizando servidor");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}