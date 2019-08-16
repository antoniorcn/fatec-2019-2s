package edu.curso;

public class ConcatenarTextos {

	public static void main(String[] args) {
		// String texto = ".";
		StringBuffer texto = new StringBuffer();
		long inicio = System.currentTimeMillis();
		System.out.println("Inicio");
		for (int i = 0; i < 10000000; i++) { 
			// texto = texto + ".";		
			texto.append('.');
		}
		long fim = System.currentTimeMillis();
		System.out.println("Termino");
		long dif = fim - inicio;
		System.out.println("Demorou " + dif + " milisegundos");
	}

}
