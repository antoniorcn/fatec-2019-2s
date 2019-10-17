package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
@EnableWebMvc
@ComponentScan("edu.curso.controllers")
public class ConfiguracaoThymeleaf implements WebMvcConfigurer {
	@Autowired
	ApplicationContext ctx;
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		SpringResourceTemplateResolver tr = 
				new SpringResourceTemplateResolver();
		tr.setApplicationContext(ctx);
		tr.setPrefix("/WEB-INF/views/");
		tr.setSuffix(".html");
		tr.setTemplateMode(TemplateMode.HTML);
		tr.setCacheable(true);

		SpringTemplateEngine te = new SpringTemplateEngine();
		te.setTemplateResolver( tr );
		te.setEnableSpringELCompiler(true);
		
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine( te );
		registry.viewResolver(resolver);
	}
}
