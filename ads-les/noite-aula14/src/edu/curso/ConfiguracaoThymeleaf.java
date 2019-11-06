package edu.curso;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import edu.curso.entidade.Usuario;

@Configuration
@EnableWebMvc
@ComponentScan("edu.curso.controller")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"edu.curso.repository"})
public class ConfiguracaoThymeleaf implements WebMvcConfigurer {
	@Autowired
	ApplicationContext ctx;
	
	@Bean
	public DataSource dataSource() {
	try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUsername("root");
			dataSource.setPassword("");
			dataSource.setUrl(
				"jdbc:mariadb://localhost/entregasdb?createDatabaseIfNotExist=true"); 
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
		hibernateProp.put("hibernate.format_sql", true);
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
		factoryBean.setPackagesToScan("edu.curso.entidades");
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
	
	@Bean
	@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Usuario sessionUser() { 
		return new Usuario();
	}
}
