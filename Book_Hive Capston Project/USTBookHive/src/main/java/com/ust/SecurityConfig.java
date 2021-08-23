package com.ust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 @Autowired
	    private UserDetailsService userService;

	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userService);
	    }


	    public void configure(HttpSecurity http) throws Exception {
	    	System.out.println("Security check - configure");
	        http.csrf().disable().httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers("/u/**").permitAll()
	                .antMatchers("/","/applogout","/logoutsuccess").permitAll()
	                .antMatchers("/a/**").hasAnyRole("ADMIN")
	                .antMatchers("/c/**").hasAnyRole("USER","CART")
	                .and()
	                .formLogin().permitAll().defaultSuccessUrl("/success")
	                .and().exceptionHandling()
	                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
	                .and().logout()
	                .logoutSuccessHandler((req,res,auth)->res.sendRedirect("/logoutsuccess"))
	                .logoutUrl("/applogout").clearAuthentication(true).deleteCookies("JSESSIONID")
	                .invalidateHttpSession(true);
}
	    @Bean
	    PasswordEncoder encoder(){
	        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
	        return encoder;
	    }
}
