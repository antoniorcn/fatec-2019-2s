package edu.curso;

public class UsoStringBuffer {

	public static void main(String[] args) {
		System.out.println("Inicio");
		long start = System.currentTimeMillis();
		String h = "H";
		// String texto = ".";
		StringBuffer texto = new StringBuffer(".");
		for (int i = 0; i < 100000; i++) { 
			// texto = texto + ".";
			texto.append(".");
		}
		long end = System.currentTimeMillis();
		long dif = end - start;
		// System.out.println(texto);
		System.out.println("Termino");
		// System.out.println("Gastou " + dif + " milisegundos");
		System.out.println(
				String.format("Gastou %d milisegundos", dif));

	}

}
