package edu.curso;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Conjuntos1 {

	public static void main(String[] args) {
		Set conjunto = new HashSet();
		conjunto.add("Antonio");
		conjunto.add(10);
		conjunto.add(15.3f);
		conjunto.add(new Date());
		
		for( Object o : conjunto) { 
			System.out.println(o);
		}
		

	}

}
