package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("edu.curso.controllers")
public class Configuracao implements WebMvcConfigurer {
	
	@Autowired
	ApplicationContext appCtx;
	
	@Bean
	public ViewResolver viewResolver() { 
		UrlBasedViewResolver vr = new UrlBasedViewResolver();
		vr.setPrefix("/WEB-INF/jsp/");
		vr.setSuffix(".jsp");
		vr.setViewClass(JstlView.class);
		vr.setApplicationContext(appCtx);
		return vr;		
	}

}
