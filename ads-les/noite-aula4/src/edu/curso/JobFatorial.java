package edu.curso;

import java.math.BigInteger;

public class JobFatorial implements Runnable{
	@Override
	public void run() {
		BigInteger fatorial = BigInteger.ONE;
		BigInteger numero = BigInteger.ONE;
//		while (
//		numero.min(new BigInteger("100")) == numero) {
		while(true) {
			fatorial = fatorial.multiply(numero);
			String texto = String
				.format("%d! - %d", numero, fatorial);
			System.out.println(texto);
			numero = numero.add(BigInteger.ONE);
			try {
				Thread.sleep(10);
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
