package edu.curso;

import java.util.LinkedHashSet;
import java.util.Set;

public class TesteHashSet {
	
	public static void imprimeConjunto(Set<Object> conjunto) { 
		for (Object o : conjunto) { 
			System.out.println(o);
		}
	}
	
	public static void main(String[] args) {
		Set<Object> hashSet = new LinkedHashSet<>();
		hashSet.add(10.5);
		hashSet.add(15.6f);
		hashSet.add(true);
		hashSet.add("Teste de Texto");
		hashSet.add("Teste de String");
		imprimeConjunto(hashSet);
		
	}
}
