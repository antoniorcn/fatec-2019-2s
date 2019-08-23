package edu.curso;

public class Funcionario {
	double salario;
//	public void adicionarBeneficios(float vt, float vr) { 
//		salario += vt;
//		salario += vr;
//	}
//	public void adicionarBeneficios(
//			float vt, float vr, float va) { 
//		adicionarBeneficios(vt, vr);
//		salario += va;
//	}
	
	public void adicionarBeneficios(float ... beneficios) {
		for(float b : beneficios) { 
			salario += b;
		}
	}
	
	
	
	
}
