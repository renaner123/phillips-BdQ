package com.phillips.saper.bancoquestoes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/v1/clients/").permitAll()
                .requestMatchers(HttpMethod.GET, "/v1/clients").permitAll()
                .requestMatchers(HttpMethod.POST, "/v1/students/").permitAll()
                .requestMatchers(HttpMethod.POST, "/v1/teachers/").permitAll()
                .requestMatchers(HttpMethod.POST, "/v1/materials/").permitAll()
                .requestMatchers(HttpMethod.GET, "/v1/disciplines").permitAll()
                .requestMatchers(HttpMethod.GET, "/v1/subjects").permitAll()
                .requestMatchers(HttpMethod.GET, "/v1/tests").permitAll()
                .requestMatchers(HttpMethod.POST, "/v1/tests").permitAll()
                .requestMatchers(HttpMethod.PUT, "/v1/tests/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/v1/questions/tags/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/v1/questions/certified/**").hasRole("CERTIFIER")
                .requestMatchers(HttpMethod.GET, "/v1/materials/").permitAll()
                .requestMatchers("/auth/authenticate").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
                .requestMatchers("/public/**", "/v1/auth/**").permitAll()
                .requestMatchers("/", "/error", "/csrf", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs",
                        "/v3/api-docs/**")
                .permitAll()
                .anyRequest().hasAnyRole("ADMIN", "TEACHER", "CERTIFIER");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().and().csrf().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
