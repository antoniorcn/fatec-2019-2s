package edu.curso;

public class TesteString {

	public static void main(String[] args) {
		String a = "ABC";
		String b = "ABC";
		
		a = a + "";
		b = b + "";
		System.out.println("(" + a +") e (" + b + ")  são:");
		if (a.equals(b)) { 
			System.out.println("Iguais");
		} else { 
			System.out.println("Diferentes");
		}

	}

}
