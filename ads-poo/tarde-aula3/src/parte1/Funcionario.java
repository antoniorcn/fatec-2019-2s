package parte1;

public class Funcionario {
	double salario;

	public Funcionario() { 
		this(937.00f);
	}
	
	public Funcionario(float salarioInicial) { 
		salario = salarioInicial;
	}
	
	
	public void adicionarBeneficios(float ... b
			) { 
//		for( int i = 0; i < b.length; i++) { 
//			salario += b[i];
//		}
		for( float beneficio : b) { 
			salario += beneficio;
		}
	}
	
	public void toPrint() { 
		System.out.println("Salario: " + salario);
	}
	
//	public void adicionarBeneficios(float a, float b) { 
//		salario += a;
//		salario += b;
//	}
//	
//	public void adicionarBeneficios(float a, float b, float c) { 
//		adicionarBeneficios(a, b);
//		salario += c;
//	}
}
