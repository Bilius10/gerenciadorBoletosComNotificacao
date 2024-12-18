package com.boletos.Gerenciar.INFRA.SecurityAcess;

import com.boletos.Gerenciar.SERVICE.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;
    @Autowired
    private AuthenticationService authenticationService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/registry").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/user/{id}").hasRole("COBRADOR")
                        .requestMatchers(HttpMethod.PUT, "/user").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE, "/user/{id}").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/user/fatura/{id}").hasRole("COBRADOR")
                        .requestMatchers(HttpMethod.GET, "/banco").hasRole("COBRADOR")
                        .requestMatchers(HttpMethod.GET, "/banco/{id}").hasRole("COBRADOR")
                        .requestMatchers(HttpMethod.POST, "/banco").hasRole("COBRADOR")
                        .requestMatchers(HttpMethod.PUT, "/banco").hasRole("COBRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/banco{id}").hasRole("COBRADOR")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
