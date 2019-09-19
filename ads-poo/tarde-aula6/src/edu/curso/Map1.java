package edu.curso;

import java.util.HashMap;
import java.util.Map;

public class Map1 {

	public static void main(String[] args) {
		Map<String, Object> bolsa = new HashMap<>();
		bolsa.put("MAO DIREITA", "Espada de Ferro");
		bolsa.put("MAO ESQUERDA", "Escudo de Madeira");
		bolsa.put("POTIONS", 7);
		bolsa.put("VIDAS", 3);
		bolsa.put("LIFE", 10);
		bolsa.put("FLECHAS", 15);
		bolsa.put("DINHEIRO", 35.4f);
		bolsa.put("ITEMS", new String[] {"FLAUTA", "ARMADURA", "INSIGNIA"});
		bolsa.put("ARCO", "Arco de crina de cavalo");
		
		String[] listaItems = (String[]) bolsa.get("ITEMS");
		for(String i : listaItems) {
			System.out.println(i);
		}
		
	}

}
