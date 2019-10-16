package edu.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("edu.curso.controller")
@EnableWebMvc   
public class Configuracao {
	
	@Bean
	public UrlBasedViewResolver viewResolver() { 
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/jsp/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        return resolver;  
	}

}
