package edu.curso;

public class UsoFormat {
	public static void main(String[] args) {
		float a = 39.7856423f;
		int i = 3384653;
		boolean b = false;
		String t = "TEXTO";
		char c = 'X';
		System.out.println(
				String.format("Numero Float: %6.2f", a));
		System.out.println(
				String.format("Numero Inteiro: %d", i));
		System.out.println(
				String.format("Boolean: %s", b));
		System.out.println(
				String.format("Texto: %s", t));
		System.out.println(
				String.format("Charactere: %c", c));
	}
}
