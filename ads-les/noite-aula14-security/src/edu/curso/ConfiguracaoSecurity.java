package edu.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSecurity extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder getEncoder() { 
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/administrador").hasRole("ADMIN")
		.antMatchers("/principal").hasAnyRole("ADMIN", "GUEST")
		.antMatchers("/*").authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/loginController")
		.defaultSuccessUrl("/principal")
		.usernameParameter("username")
		.passwordParameter("password")
		.failureUrl("/erro")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.and().csrf().disable();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.inMemoryAuthentication()
			.withUser("guest")
			.password(getEncoder().encode("guest"))
			.roles("GUEST")
			.and()
			.withUser("admin")
			.password(getEncoder().encode("admin"))
			.roles("ADMIN");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
