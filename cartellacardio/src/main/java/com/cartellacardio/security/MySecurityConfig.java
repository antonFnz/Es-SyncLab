package com.cartellacardio.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource myDataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
	  throws Exception {
		
		// admin config
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("admin").password("admin").authorities("ADMIN"));
		
		// db retrieve config - adapted for own schema
	    auth.jdbcAuthentication()
	      .dataSource(myDataSource)
	      .usersByUsernameQuery("select username,password,iduser "
	        + "from User "
	        + "where username = ?")
	      .authoritiesByUsernameQuery("select username,ruolo "
	        + "from User "
	        + "where username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").hasAnyAuthority("ADMIN", "MEDICO", "PAZIENTE")
			.antMatchers("/user/**").hasAuthority("ADMIN")
			.antMatchers("/doctor/**").hasAuthority("MEDICO")
			.antMatchers("/patient/**").hasAuthority("PAZIENTE")
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied")
			.and()
			.logout().permitAll();
		
	}

}
