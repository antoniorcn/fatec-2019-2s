package edu.curso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TesteGravacaoArquivo {
	public static void main(String[] args) {
		File f = new File("C:/tmp2/arquivo.txt");
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("A");
			fw.write("B");
			fw.flush();
			fw.write("C");
			fw.write("\r\nLinha 2 Hello World");
			fw.close();
			System.out.println("Gravado no arquivo");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
