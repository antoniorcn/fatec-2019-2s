package edu.curso;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {
@Override
protected Class<?>[] getRootConfigClasses() {
	return new Class<?>[]{
		SecurityConfig.class};
}
@Override
protected Class<?>[] getServletConfigClasses() {
	return new Class[] { Configuracao.class };
}
@Override
protected String[] getServletMappings() {
	return new String[] { "/" };
}
}
