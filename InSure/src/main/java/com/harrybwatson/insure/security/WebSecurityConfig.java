package com.harrybwatson.insure.security;

import com.harrybwatson.insure.user.service.AgentUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security Config class using Spring Security
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AgentUserDetailService();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        BCryptPasswordEncoder passwordEncoder = passwordEncoder();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }

    // Defining Web Security Session
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf()
                    .disable()
                    .authorizeRequests()
                    .antMatchers("/user/**", "/policy/**", "/customer/**", "/phr", "/portal")
                    .authenticated()
                    .and()
                    .formLogin()
                    .usernameParameter("user_email")
                    .defaultSuccessUrl("/portal")
                    .and()
                    .logout().logoutSuccessUrl("/").permitAll();
            return http.build();
    }


}
