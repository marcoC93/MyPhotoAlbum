package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() 
			.antMatchers("/admin").hasRole("ADMIN")  /* può essere acceduto solo da chi ha ruoo ADMIN */
			.antMatchers("/admin/**").hasRole("ADMIN") /*  i * indicano che  ogni pagina che inizia con il payh/admin/ ha le stesse impostazioni di cui sopra*/
			.antMatchers("/").permitAll()  /* */
			.and().formLogin() /* Indica che l'accesso avviene tramite form di Login*/
			.loginPage("/login") /* Dove è localizzato il form di login , la stringa indica il percorso */
			.and().csrf().disable(); /* Indica funzioni di sicurezza avanzata per non permettere accesso indesiderato alle API
			(disabilitato a scopo didattico )  */
	
	
	
	}
	
	 @Override
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception {
		auth.userDetailsService(userDetailsService );
	}

}
