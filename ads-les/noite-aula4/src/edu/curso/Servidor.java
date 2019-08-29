package edu.curso;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
	public static void main(String[] args) {
		try (ServerSocket srv = new ServerSocket(15678)){
			System.out.println("Iniciando servidor");
			while(true) {
				System.out.println("Aguardando conexão do cliente");
				Socket cli = srv.accept();
				JobSocket j1 = new JobSocket(cli);
				Thread t1 = new Thread(j1);
				t1.start();
				System.out.println("Cliente conectado");
			}
			//System.out.println("Finalizando servidor");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}