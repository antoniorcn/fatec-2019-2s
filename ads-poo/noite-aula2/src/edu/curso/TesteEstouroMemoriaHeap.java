package edu.curso;
public class TesteEstouroMemoriaHeap {
	public static void main(String[] args) 
			throws InterruptedException {
		int [][] principal = new int[50000][];
		for (int i = 0; i < 50000; i++) { 
			int[] temp = new int[100000];
			principal[i] = temp;
			System.out.println(i);
			Thread.sleep(1);
		}
	}
}
