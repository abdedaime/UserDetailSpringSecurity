package com.hicham.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/***
 * 
 * @author hicham-abdedaime
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private RedirectClass AuthenticationSuccessHandler;

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		String[] unsecuredResources = { "/resources/**" };
		web.ignoring().antMatchers(unsecuredResources);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);

	}

	/*
	 * @Autowired public void
	 * configureGlobalSecurity(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("hicham").password("123")
	 * .roles("USER", "MANGER_RH");
	 * auth.inMemoryAuthentication().withUser("admin").password("123")
	 * .roles("ADMIN");
	 * auth.inMemoryAuthentication().withUser("consultant").password("123")
	 * .roles("ADMIN", "USER"); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
		/*
		 * .antMatchers("/", "/home").permitAll()
		 * .antMatchers("/admin/**").access("hasRole('ADMIN')")
		 * .antMatchers("/con/**"
		 * ).access("hasRole('ADMIN') and hasRole('CONSU')")
		 */
		.and().formLogin().loginPage("/login").permitAll()
				.usernameParameter("useranme").passwordParameter("mot_passe")
				.failureUrl("/login?error=1")
				.successHandler(AuthenticationSuccessHandler).and().csrf()
				.disable().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login");
		// .and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}
