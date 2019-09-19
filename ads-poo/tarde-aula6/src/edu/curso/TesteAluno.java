package edu.curso;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CarroCorrida { 
	String tipo;
	int velocidadeMaxima = 0;
	
	CarroCorrida(String t) { 
		tipo = t;
	}
}

class Veloster extends CarroCorrida { 
	Veloster() { 
		super("veloster");
		velocidadeMaxima = 210;
	}
}

class Brasilia extends CarroCorrida { 
	Brasilia() { 
		super("brasilia");
		velocidadeMaxima = 110;
	}
}

class Sentra extends CarroCorrida { 
	Sentra() { 
		super("sentra");
		velocidadeMaxima = 180;
	}
}

class Monza extends CarroCorrida { 
	Monza() { 
		super("monza");
		velocidadeMaxima = 200;
	}
}

class Fusca extends CarroCorrida { 
	Fusca() { 
		super("fusca");
		velocidadeMaxima = 100;
	}
}

class Ka extends CarroCorrida { 
	Ka() { 
		super("ka");
		velocidadeMaxima = 120;
	}
}

public class TesteAluno {

	public static void main(String[] args) {
		// Calculo de Velocidade Maxima dos Carros
		/*
		 * Brasilia = 110km/h
		 * Veloster = 210km/h
		 * Sentra = 180km/h
		 * Monza = 200km/h
		 * Fusca = 100km/h
		 * 
		 */
		System.out.println("Escolha um carro de corrida");
		System.out.println("(B) - Brasilia");
		System.out.println("(S) - Sentra");
		System.out.println("(V) - Veloster");
		System.out.println("(M) - Monza");
		System.out.println("(F) - Fusca");
		System.out.println("(K) - Ka");
		
		Scanner scan = new Scanner(System.in);
		String escolha = scan.nextLine();
		scan.close();
		
		CarroCorrida c1 = null;
		
		Map<String, CarroCorrida> carros = new HashMap<>();
		carros.put("B", new Brasilia());
		carros.put("S", new Sentra());
		carros.put("V", new Veloster());
		carros.put("M", new Monza());
		carros.put("F", new Fusca());
		carros.put("K", new Ka());
		
		c1 = carros.get(escolha);

//		int vel = 0;
//		if ("brasilia".equals(c1.tipo)) { 
//			vel = 110;
//		} else if ("veloster".equals(c1.tipo)) { 
//			vel = 210;
//		} else if ("sentra".equals(c1.tipo)) { 
//			vel = 210;
//		} else if ("monza".equals(c1.tipo)) { 
//			vel = 200;
//		} else if ("fusca".equals(c1.tipo)) { 
//			vel = 100;
//		}
		
		System.out.println("Velocidade maxima do Carro " + 
		c1.tipo + " é de : " + c1.velocidadeMaxima + "km/h" );

	}

}
