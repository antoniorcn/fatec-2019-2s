package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App3 {
	
	public static void main(String[] args) {
		ApplicationContext app = 
			new AnnotationConfigApplicationContext(
				Configuracao.class);
		Pessoa pa = app.getBean("pessoa1", Pessoa.class);
		pa.falar();
		Pessoa pb = app.getBean("pessoa1", Pessoa.class);
		pb.falar();
		Pessoa p2 = app.getBean("pessoa2", Pessoa.class);
		p2.falar();
		
		System.out.println(pa);
		System.out.println(pb);
		System.out.println(p2);
	}

}
