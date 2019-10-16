package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@ComponentScan("edu.curso.controller")
@EnableWebMvc   
public class Configuracao implements WebMvcConfigurer {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		SpringResourceTemplateResolver tr = new SpringResourceTemplateResolver();
		tr.setApplicationContext(applicationContext);
		tr.setPrefix("/WEB-INF/views/");
		tr.setSuffix(".html");
		tr.setTemplateMode(TemplateMode.HTML);
		tr.setCacheable(true);
		
		SpringTemplateEngine te = new SpringTemplateEngine();
		te.setEnableSpringELCompiler(true);
		te.setTemplateResolver(tr);
		
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setTemplateEngine(te);
		registry.viewResolver(resolver);
	}

}
