package edu.curso;

public class TestaStackOverflow {
	static int count = 0;
	public static void main(String[] args) {
		int a = 0;
		System.out.println(count++);
		main(args);
	}

}
