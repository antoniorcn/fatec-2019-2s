package edu.curso;
public class JobNumeros 
	implements Runnable{
	private String nome;
	public JobNumeros(String nome) { 
		this.nome = nome;
	}
	@Override
	public void run() {
		for (int i = 0; i <= 1000000000; i++) { 
			System.out.println(nome + " - " + i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
