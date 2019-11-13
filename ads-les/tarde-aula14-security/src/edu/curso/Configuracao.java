package edu.curso;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration		// Indica que é um arquivo de configuração
@EnableWebMvc		// Ativa o uso do WebMVC
@ComponentScan("edu.curso.controller")	// Onde estão os controllers
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"edu.curso.repository"})
public class Configuracao implements WebMvcConfigurer{
	
	
	@Autowired
	ApplicationContext appContext;
	
	public Configuracao() { 
		URL url = Configuracao.class.getClassLoader().getResource("/resources/");
		System.out.println("Path: " + url.getFile());
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("Add Resource Handlers iniciado");
	    // TODO Auto-generated method stub
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	   
	}   

	@Bean("messageSource")
	public MessageSource messageSource() {
		System.out.println("Message Source iniciado");
		ResourceBundleMessageSource messageSource
	      = new ResourceBundleMessageSource ();
	    messageSource.setBasenames("classpath:/resources/messages");
	    messageSource.setDefaultEncoding("UTF-8");
//	    Resource cproot =
//	    	    appContext.getResource("classpath:/resources/messages.properties");
//	    try {
//			System.out.println(cproot.getFile().getAbsolutePath());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	    return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		System.out.println("Locale Resolver iniciado");
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		MessageService.getInstance().setApplicationContext(appContext);
	    System.out.println(MessageService.getInstance().getMessage("user", "User Name Default:"));
		return localeResolver;
	}

	@Bean
	public DataSource dataSource() {
		System.out.println("Data Source iniciado");
		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("");
			dataSource.setUrl(
					"jdbc:mariadb://localhost/brinquedodb?createDatabaseIfNotExist=true"); 
			return dataSource;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", 
				"org.hibernate.dialect.MariaDB53Dialect");
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.format_sql", false);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		return hibernateProp;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}


	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean =
				new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("edu.curso.entidade");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}


	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		SpringResourceTemplateResolver tr = new SpringResourceTemplateResolver();
		tr.setApplicationContext(appContext);
		tr.setPrefix("/WEB-INF/views/");
		tr.setSuffix(".html");
		tr.setTemplateMode(TemplateMode.HTML);
		tr.setCacheable(true);

		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(tr);
		templateEngine.setEnableSpringELCompiler(true);

		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine);
		registry.viewResolver(resolver);
	}
}
