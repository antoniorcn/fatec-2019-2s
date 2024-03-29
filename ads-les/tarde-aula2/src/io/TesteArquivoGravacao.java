package io;

import java.io.File;
import java.io.FileWriter;

public class TesteArquivoGravacao {

	public static void main(String[] args) {
		System.out.println("Inicio do teste de grava��o de arquivo");
		try { 
			File f = new File("C:/tmp2/MeuArquivo.txt");
			System.out.println(
				String.format("Arquivo %s existe %s", 
						f.getAbsolutePath(), f.exists())
				);
			System.out.println(
				String.format("Pode ler o arquivo: %s", f.canRead()));
			System.out.println(
				String.format("Pode gravar no arquivo: %s", f.canWrite()));
			System.out.println(
				String.format("Caminho � de um arquivo ?: %s", f.isFile()));
			System.out.println(
				String.format("Caminho � de um pasta ?: %s", f.isDirectory()));
			FileWriter fw = new FileWriter(f, true);
			fw.write("Ola mundo...\n");
			fw.flush();
			fw.write("Linha2\n");
			fw.close();
		} catch(Exception e) { 
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}
}
