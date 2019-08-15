package edu.curso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TesteGravacaoObjetos {
	public static void main(String[] args) {
		String[] nomes = {"João", "Maria", "Colevati", "Jose", "Michael", 
				"Cristina", "Vendramel"};
		try { 
			File f = new File("C:/tmp2/nomes.bin");
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream objOut = new ObjectOutputStream(fout);
			objOut.writeObject(nomes);
			objOut.close();
			System.out.println("Objeto gravado");
		} catch(IOException e) { 
			e.printStackTrace();
		}
	}
}
