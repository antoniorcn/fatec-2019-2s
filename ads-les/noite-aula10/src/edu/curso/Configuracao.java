package edu.curso;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {
	
	@Bean
	public Pessoa pessoa1() { 
		return new Pessoa();
	}

	@Bean
	public Pessoa pessoa2() { 
		Pessoa p = new Pessoa();
		return p;
	}
}
