package edu.curso;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class JobSocket implements Runnable{
	private Socket cli;
	public JobSocket(Socket s) { 
		this.cli = s;
	}
	
	@Override
	public void run() {
		try {
			OutputStream out = cli.getOutputStream();
			InputStream in = cli.getInputStream();
			out.write("Bem vindo ao servidor Java".getBytes());
			out.flush();
			int i = 0;
			boolean sair = false;
			while (!sair) {
				if (in.available() > 0) { 
					i = in.read();
					System.out.print((char)i);
					if (i == 27) { 
						sair = true;
					}
				}
				if (System.in.available() > 0) { 
					i = System.in.read();
					out.write(i);
					out.flush();
					if (i == 27) { 
						sair = true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
