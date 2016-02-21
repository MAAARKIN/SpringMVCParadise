package br.com.filhow.paradise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired private UserDetailsService userDetailsService;

	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/scripts/**/*.{js,html}")
            .antMatchers("/bower_components/**")
            .antMatchers("/i18n/**")
            .antMatchers("/assets/**")
            .antMatchers("/swagger-ui/index.html")
            .antMatchers("/test/**");
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
//		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//		auth.inMemoryAuthentication().withUser("mark").password("mark").roles("USER");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
//		http
//		.csrf()
//        .disable()
//        .headers()
//        .frameOptions()
//        .disable()
//        .and()
//        .authorizeRequests() 
//        .antMatchers("/").permitAll()
//        .antMatchers("/users/**").hasAuthority("ADMIN")
//        .antMatchers("/greeting").authenticated()
//            .and()
//        .formLogin()
//            .loginPage("/login")
//            .permitAll()
//            .and()
//        .logout()                                    
//            .permitAll();
		
		http
	        .csrf()
	        .disable()
	        .headers()
	        .frameOptions()
	        .disable()
	      //somente utilizado em arquiteturas stateless
//	    .and().sessionManagement() .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .usernameParameter("email")
            .permitAll()
            .and()
        .logout()
        	.logoutUrl("/logout")
        	.logoutSuccessUrl("/")
            .permitAll()
        .and()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/users/**").hasAuthority("ADMIN")
            .antMatchers("/greeting").authenticated();
    }
	
}
