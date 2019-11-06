package edu.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) {
		try {
			auth.inMemoryAuthentication()
			.withUser("user1")
			.password(passwordEncoder().encode("user1Pass"))
			.roles("USER")
			.and()
			.withUser("user2")
			.password(passwordEncoder().encode("user2Pass"))
			.roles("USER")
			.and()
			.withUser("admin")
			.password(passwordEncoder().encode("adminPass"))
			.roles("ADMIN");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
        .authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/anonymous*").anonymous()
        .antMatchers("/login*").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
		.loginProcessingUrl("/loginController")
		.loginPage("/login")
		.failureUrl("/error").permitAll()
		.defaultSuccessUrl("/principal")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
