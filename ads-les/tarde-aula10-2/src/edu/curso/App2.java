package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
	public App2() { 
		ApplicationContext app = 
				new AnnotationConfigApplicationContext (SpringConfigurationTeste.class);
			Pessoa p = app.getBean("pessoa", Pessoa.class);
			p.falar();
	}
	public static void main(String[] args) {
		new App2();
	}

}
