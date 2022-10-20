package com.example.todobackend.configuration;

import com.example.todobackend.configuration.jwt.AuthEntryPointJwt;
import com.example.todobackend.configuration.jwt.AuthTokenFilter;
import com.example.todobackend.configuration.services.UserDetailsServiceImpl;
import com.example.todobackend.log.InfoLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(

        prePostEnabled = true)
public class WebSecurityConfig {
    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean // Token filtrelemesi init
    public AuthTokenFilter authenticationJwtTokenFilter() {
        AuthTokenFilter authTokenFilter = new AuthTokenFilter();
        logger.debug(authTokenFilter.toString());
        return authTokenFilter;

    }

    @Bean // Spring boot security
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(); // Spring boot tarafindan geliyor

        try {
            authProvider.setUserDetailsService(userDetailsService);
            authProvider.setPasswordEncoder(passwordEncoder()); // bcrypt / argon2
            return authProvider;
        } catch (Exception e) {
            logger.error("sadasde: {}", e.getMessage());
            throw e;
        }

    }

    @Bean // Spring Boot Security
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        logger.info("Authentication manager is initiated");
        return authConfig.getAuthenticationManager();
    }

    @Bean // Bcrypt
    public PasswordEncoder passwordEncoder() {
        logger.info("initialized bcrypt");
        return new BCryptPasswordEncoder();
    }

    @InfoLogger("Initiated security services") // logger.info
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and() // token yoksa auth hatasi veriyor
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // cache
                .authorizeRequests().antMatchers("/auth/**").permitAll() //auth endpointini kabul et
                .anyRequest().authenticated(); // geri kalani reddet

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

// JWT - Service
// Util - Filter - Entrance Point