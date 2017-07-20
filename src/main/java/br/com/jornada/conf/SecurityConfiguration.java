package br.com.jornada.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.jornada.daos.UsuarioSecurityDAO;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioSecurityDAO usuarioDao;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("ADMIN")
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/evento").permitAll()
		.antMatchers("/usuarios/**").permitAll()
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDao).passwordEncoder(new BCryptPasswordEncoder());
	}
}