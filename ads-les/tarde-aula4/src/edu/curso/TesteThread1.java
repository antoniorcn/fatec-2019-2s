package edu.curso;

public class TesteThread1 {
	public static void main(String[] args) {
		JobNumeros j1 = new JobNumeros("A");
		JobNumeros j2 = new JobNumeros("B");
		Thread t1 = new Thread( j1 );
		Thread t2 = new Thread( j2 );
		System.out.println("Estado Novo");
		t1.start();				
		t2.start();
		System.out.println("Estado Executável");
	}
}
