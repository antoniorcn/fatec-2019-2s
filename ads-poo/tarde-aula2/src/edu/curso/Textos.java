package edu.curso;

public class Textos {
	public static void main(String[] args) {
		String a = "ABC";
		String b = "ABC";
		b = b + "";
		
		System.out.println("A: (" + a + ")  B: (" + b + ")");
		
		if (a.equals(b)) { 
			System.out.println("Iguais");
		} else { 
			System.out.println("Diferentes");
		}
	}


}
