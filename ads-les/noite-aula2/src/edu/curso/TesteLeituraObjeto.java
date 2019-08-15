package edu.curso;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TesteLeituraObjeto {
	public static void main(String[] args) {
		try {
			File f = new File("C:/tmp2/nomes.bin");
			FileInputStream fin = new FileInputStream(f);
			ObjectInputStream objIn = new ObjectInputStream(fin);
			String[] o = (String[])objIn.readObject();
			for (String nome: o) {
				System.out.println("Nome: " + nome);
			}
			objIn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
