package io;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
public class TesteGravacaoObjeto {
	public static void main(String[] args) {
		String[] nomes = {"Bruno", "Helio", "Wellington", "Satoshi", 
				"Colevatti", "Cristina", "Takeu", "Le�ncio"};
		File f = new File("c:/tmp2/nomes.dat");
		try { 
			FileOutputStream fout = new FileOutputStream(f);
			ObjectOutputStream objOut = new ObjectOutputStream(fout);
			objOut.writeObject(nomes);
			objOut.close();
			System.out.println("Nomes gravados no arquivo");
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
