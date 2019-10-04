package edu.curso;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	static enum ControleAcesso {
		CAIXA, RELATORIOS, CONFIGURAR, CADASTRAR, ADMINISTRAR
	}
	
	public static void relatorios(Set<ControleAcesso> usuario) {
		if (usuario.contains(ControleAcesso.RELATORIOS)) { 
			System.out.println("Imprimindo relatorio");
		} else  {
			System.out.println("Não tem autorização");
		}
	}

	
	public static void main(String[] args) {
		Set<ControleAcesso> gerente = new HashSet<>();
		Set<ControleAcesso> operador = new HashSet<>();
		
		gerente.add(ControleAcesso.CAIXA);
		gerente.add(ControleAcesso.CADASTRAR);
		gerente.add(ControleAcesso.RELATORIOS);
		
		operador.add(ControleAcesso.CAIXA);
		
		relatorios(operador);
		
		
	}
}
