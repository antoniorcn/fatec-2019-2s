package edu.polimorfismo;

public class RH {
	
	public float calculaBonusFuncionario(Funcionario func) {
		float bonus = 0;
		if (func.getFaltasNoAno() < 2) { 
			bonus = 0.7f;
		} else if (func.getFaltasNoAno() < 4) {
			bonus = 0.3f;
		} else { 
			bonus = 0.1f;
		}
		return bonus;
	}
	
	public static void main(String[] args) {
		RH rh = new RH();
		Funcionario f1 = new Funcionario();
		f1.setFaltasNoAno(1);
		
		Funcionario f2 = new Funcionario();
		f2.setFaltasNoAno(3);
		
		Funcionario f3 = new Funcionario();
		f3.setFaltasNoAno(7);
		
		System.out.println("Bonus de F1: " + rh.calculaBonusFuncionario(f1));
		System.out.println("Bonus de F2: " + rh.calculaBonusFuncionario(f2));
		System.out.println("Bonus de F3: " + rh.calculaBonusFuncionario(f3));
	}

}
