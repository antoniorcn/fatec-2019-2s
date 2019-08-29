package edu.curso;

public class Aeronave {
	
	Piloto piloto;
	Passageiro p1;
	Passageiro p2;
	Passageiro p3;
	
	public void decolar() { 
		System.out.println("Decolando");
		piloto.voar();
	}
	

}
