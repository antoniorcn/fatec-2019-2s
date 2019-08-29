package edu.curso;
public class JobNumeros 
	implements Runnable{
	private String nome;
	public JobNumeros(String n) { 
		this.nome = n;
	}
	@Override
	public void run() {
		for(int i = 0; i <= 100; i++) { 
			System.out.println(
					this.nome + " - " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
