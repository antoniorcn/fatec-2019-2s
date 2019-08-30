package edu.curso;

public class Aeronave {
	String id;
	String empresa;
	Passageiro p1;
	Passageiro p2;
	Piloto piloto;
	public void decolar() { 
		System.out.println("Aeronave decolando");
		piloto.pilotar();
	}
	public void embarcar(Passageiro p1, Passageiro p2) { 
		this.p1 = p1;
		this.p2 = p2;
		p1.embarcar();
		p2.embarcar();
	}
	

}
