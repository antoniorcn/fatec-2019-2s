package edu.curso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteList {
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		
		lista.add("ZZZZ");
		lista.add("AAAA");
		lista.add("YYYY");
		
		Collections.sort(lista);
		
		System.out.println(lista.get(0));
	}

}
