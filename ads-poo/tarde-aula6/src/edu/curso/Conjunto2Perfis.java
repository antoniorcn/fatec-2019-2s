package edu.curso;

import java.util.HashSet;
import java.util.Set;

public class Conjunto2Perfis {
	public static void main(String[] args) {
		Set<String> perfis = new HashSet<>();
		perfis.add("Medico");
		perfis.add("Medico");
		perfis.add("Enfermeiro");
		perfis.add(null);
		perfis.add("Paciente");
		
		// Listas os perfis 
		for (String perfil : perfis) { 
			System.out.println(perfil);
		}
		
		// Pode acesssar dado do enfermeiro
		if (perfis.contains("Enfermeiro")) { 
			System.out.println("Acesso de Enfermeiro concedido");
		} else { 
			System.out.println("Não autorizado");
		}
	}
}
