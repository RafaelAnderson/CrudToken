package com.rafael.curso.springboot.app.springbootcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Filtro
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.GET,"/api/users").permitAll() // publico users
                        .requestMatchers(HttpMethod.POST,"/api/users/register").permitAll()
                        .anyRequest().authenticated()) // Lo demas requiere autenticacion
                .csrf(config -> config.disable()) // deshabilitar el token csrf
                .sessionManagement(management ->
                        management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // la sesion no tenga estado
                .build();
    }
}
