package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App2 {
	public static void main(String[] args) {
		ApplicationContext app = 
		new FileSystemXmlApplicationContext("beans.xml");
		Pessoa p1 = app.getBean("pessoa", Pessoa.class);
		Pessoa p2 = app.getBean("pessoa", Pessoa.class);
		p1.falar();
		p2.falar();
		
		System.out.println(p1);
		System.out.println(p2);
	}
}
