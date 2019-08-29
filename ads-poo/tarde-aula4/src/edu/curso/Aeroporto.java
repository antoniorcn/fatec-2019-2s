package edu.curso;

public class Aeroporto {
	
	Aeronave a1;
	Aeronave a2;
	
	Passageiro p1;
	Passageiro p2;
	Passageiro p3;
	Passageiro p4;
	Passageiro p5;
	Passageiro p6;
	
	Piloto plt1;
	Piloto plt2;
	
	Aeroporto() { 
		plt1 = new Piloto();
		plt2 = new Piloto();
		p1 = new Passageiro("João", 1001);
		p2 = new Passageiro("Maria", 1002);
		p3 = new Passageiro("Alfredo", 1003);
		p4 = new Passageiro("Fatima", 1004);
		p5 = new Passageiro("Marcelo", 1005);
		p6 = new Passageiro("Julia", 1006);
		a1 = new Aeronave();
		a2 = new Aeronave();
		a1.piloto = plt1;
		a1.p1 = p1;
		a1.p2 = p2;
		a1.p3 = p3;
		
		a2.piloto = plt2;
		a2.p1 = p4;
		a2.p2 = p5;
		a2.p3 = p6;
		
	}
	
	public static void main(String[] args) {
		Aeroporto cumbica = new Aeroporto();
		cumbica.p1.embarcar();
		cumbica.p2.embarcar();
		cumbica.p3.embarcar();
		cumbica.a1.decolar();

	}

}
