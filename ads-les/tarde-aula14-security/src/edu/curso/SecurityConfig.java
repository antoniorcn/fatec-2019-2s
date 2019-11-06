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
public class SecurityConfig extends 
		WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.inMemoryAuthentication()
			.withUser("guest")
			.password(passwordEncoder().encode("password"))
			.roles("GUEST").and()
			.withUser("admin")
			.password(passwordEncoder().encode("admin"))
			.roles("ADMIN");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/principal").hasAnyRole("GUEST", "ADMIN")
		.antMatchers("/gerenciar").hasRole("ADMIN")
		.antMatchers("/admin/*").hasRole("ADMIN")
		.and()
		.formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
		.loginProcessingUrl("/loginController")
		.loginPage("/login")
		.failureUrl("/erro").defaultSuccessUrl("/principal")
		.permitAll()
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
		.and().csrf().disable();
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

