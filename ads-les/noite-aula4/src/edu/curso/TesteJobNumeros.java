package edu.curso;
public class TesteJobNumeros {
	public static void main(String args[]) {
		JobNumeros j1 = new JobNumeros("A");
		Thread t1 = new Thread(j1);
		t1.start();
		
		JobNumeros j2 = new JobNumeros("B");
		Thread t2 = new Thread(j2);
		t2.start();
	}
}
