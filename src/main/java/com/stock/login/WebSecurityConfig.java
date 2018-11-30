package com.stock.login;

 
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.stock.service.UserSecurityService;

 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	    private Environment env;

	    @Autowired
	    private UserSecurityService userSecurityService;

	    private static final String SALT = "salt"; // Salt should be protected carefully

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	    }
	
	 private static final String[] PUBLIC_MATCHERS = {
	            "/webjars/**",
	            "/css/**",
	            "/js/**",
	            "/images/**",	          
	            "/about/**",
	            "/contact/**",
	            "/error/**/*",
	            "/console/**",
	            "/user/signUp",
	            "/user/authenticate",
	            "/stock/**"
	           
	    };
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	 http
         .authorizeRequests().
//         antMatchers("/**").
         antMatchers(PUBLIC_MATCHERS).
         permitAll().anyRequest().authenticated();
    	
        http 
        .csrf().disable().cors().disable()
//        .authorizeRequests()
//        .anyRequest().authenticated()
//        .and()
            	.formLogin()
                .loginPage("/login").defaultSuccessUrl("/portfolio").failureUrl("/failed").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index")
                .permitAll();
    }

    @Bean
    public UserDetailsService userDetailsService(AuthenticationManagerBuilder auth) {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("1")
                .password("1")
                .roles("USER")
                .build();
       

        return new InMemoryUserDetailsManager(user);
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    	 auth.inMemoryAuthentication().withUser("user").password("password").roles("USER"); //This is in-memory authentication
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }
    
}