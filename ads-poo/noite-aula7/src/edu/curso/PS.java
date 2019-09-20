package edu.curso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Doenca { 
		DOR_DEDO, DOR_BRACO, DOR_PERNA, DOR_BARRIGA, 
	CONJUTIVITE, SINUSITE, APENDICITE, PNEUMONIA, 
	SARAMPO, DENGUE_HEMORRAGICA, MENINGITE
}

class Paciente implements Comparable<Paciente>{ 
	String nome;
	Doenca doenca;
	Paciente(String n, Doenca d) { 
		nome = n;
		doenca = d;
	}
	
	@Override
	public int compareTo(Paciente o) {
		return - (this.doenca.ordinal() - o.doenca.ordinal());
	}
	
	@Override
	public String toString() { 
		return nome + " (" + doenca.name() + ")";
	}
}

public class PS {
	
	public static void main(String[] args) {
		Paciente p1 = new Paciente("Aristoteles", Doenca.CONJUTIVITE);
		Paciente p2 = new Paciente("Hercules", Doenca.PNEUMONIA);
		Paciente p3 = new Paciente("Falcao", Doenca.DENGUE_HEMORRAGICA);
		Paciente p4 = new Paciente("Lucinda", Doenca.DOR_PERNA);
		Paciente p5 = new Paciente("Lula", Doenca.DOR_DEDO);
		Paciente p6 = new Paciente("Whindersson", Doenca.SARAMPO);
		
		List<Paciente> fila = new ArrayList<>();
		fila.add(p1);
		fila.add(p2);
		fila.add(p3);
		fila.add(p4);
		fila.add(p5);
		fila.add(p6);
		
		Collections.sort(fila);
		
		for (Paciente p : fila) { 
			System.out.println(p);
		}

		
		
	}

}
