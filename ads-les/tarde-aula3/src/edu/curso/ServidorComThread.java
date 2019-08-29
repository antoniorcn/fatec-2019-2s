package edu.curso;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServidorComThread {
	public static void main(String[] args) {
		try (
			ServerSocket srv = new ServerSocket(15678)
			) {
			System.out.println("Servidor Iniciado");
			while(true) {  
				System.out.println(
						"Porta reservada, " +
						"aguardando comunicação do cliente");
				Socket s = srv.accept();
				JobConversa j = new JobConversa(s);
				Thread t = new Thread(j);
				t.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Servidor Finalizado");
	}
}
