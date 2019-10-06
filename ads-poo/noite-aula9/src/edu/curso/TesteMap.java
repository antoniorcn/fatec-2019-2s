package edu.curso;

import java.util.HashMap;
import java.util.Map;

public class TesteMap {
	
	// A 	- Aprovado com louvor
	// B 	- Aprovado
	// C 	- Aprovado na lata
	// D 	- Reprovado
	// E 	- Reprovado com louvor
	
	public static void main(String[] args) {
		Map<String, String> situacao = new HashMap<>();
		situacao.put("A", "Aprovado com louvor");
		situacao.put("B", "Aprovado");
		situacao.put("C", "Aprovado na lata");
		situacao.put("D", "Reprovado");
		situacao.put("E", "Reprovado com louvor");
		
		String nota = "E";
		
		System.out.println(
			String.format("Situação: %s", situacao.get(nota)));
		
	}

}
