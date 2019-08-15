package edu.curso;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TesteLeituraArquivo {
	public static void main(String[] args) {
		File f = new File("c:/tmp2/arquivo.txt");
		if (f.exists() && f.canRead()) {
			try (
				FileReader fr = new FileReader(f);
				) { 
				int i = 0;
				while ((i = fr.read()) != -1) {
					System.out.print((char)i);
				}
			} catch(IOException e) { 
				e.printStackTrace();
			}
		}
	}
}
