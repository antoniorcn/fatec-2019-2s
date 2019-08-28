package edu.curso;

import java.math.BigInteger;

public class JobFatorial implements Runnable {
	private static final BigInteger MAX_NUMBER 
							= new BigInteger("100");
	public void run() { 
		BigInteger numero = BigInteger.ONE;
		BigInteger fatorial = BigInteger.ONE;
		while (numero.min(MAX_NUMBER) == numero) { 
			fatorial = fatorial.multiply(numero);
			System.out.println(numero + " - " + fatorial);
			numero = numero.add(BigInteger.ONE);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		JobFatorial j1 = new JobFatorial();
		Thread t1 = new Thread(j1);
		t1.start();
	}
}
