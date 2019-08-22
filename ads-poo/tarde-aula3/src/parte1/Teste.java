package parte1;

public class Teste {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario(1000.0f);
		f1.adicionarBeneficios(100.0f, 200.0f);
		f1.toPrint();
		
		Funcionario f2 = new Funcionario();
		f2.adicionarBeneficios(100.0f, 200.0f, 250.0f);
		f2.toPrint();
	}
}
