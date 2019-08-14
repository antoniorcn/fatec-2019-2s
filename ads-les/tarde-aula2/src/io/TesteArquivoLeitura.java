package io;
import java.io.File;
import java.io.FileReader;
public class TesteArquivoLeitura {
	public static void main(String[] args) {
		File f = new File("c:/tmp2/MeuArquivo.txt");
		try { 
			FileReader fr = new FileReader(f);
			int i = 0;
			while((i = fr.read()) != -1) {
				// System.out.println("Lido Caracter: " + (char)i);
				System.out.print((char)i);
			}
			fr.close();
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
