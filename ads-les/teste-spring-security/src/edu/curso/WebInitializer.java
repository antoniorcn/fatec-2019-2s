package edu.curso;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
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

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext 
//        ctx = new AnnotationConfigWebApplicationContext(); 
//        ctx.register(Configuracao.class);  
//        
//        ctx.setServletContext(servletContext);  
//        
//        Dynamic servlet = servletContext
//        .addServlet("dispatcher", new DispatcherServlet(ctx));  
//        servlet.addMapping("/");  
//        servlet.setLoadOnStartup(1);
//	}
// }
