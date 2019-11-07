package edu.curso;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class WebInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {
@Override
protected Class<?>[] getRootConfigClasses() {
	return new Class<?>[]{
		ConfiguracaoSecurity.class};
}
@Override
protected Class<?>[] getServletConfigClasses() {
	return new Class[] { ConfiguracaoThymeleaf.class };
}
@Override
protected String[] getServletMappings() {
	return new String[] { "/" };
}
}
