package com.tour_web_app.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests((authorize) -> authorize
//                        //.requestMatchers(HttpMethod.GET, "/api/tours/**").permitAll()
//                        //.requestMatchers(HttpMethod.GET, "/api/comments/**").permitAll()
//                        .requestMatchers("/api/auth/**").permitAll()
////                        .requestMatchers(HttpMethod.POST, "/api/comments").authenticated()
////                        .requestMatchers(HttpMethod.PUT, "/api/comments/**").authenticated()
////                        .requestMatchers(HttpMethod.DELETE, "/api/comments/**").authenticated()
//                        .anyRequest().authenticated()
//                ).sessionManagement(session ->
//                        session.sessionCreationPolicy(STATELESS))
//                .oauth2ResourceServer(server -> server
//                        .jwt(Customizer.withDefaults())
//                        .authenticationEntryPoint(
//                                new BearerTokenAuthenticationEntryPoint())
//                        .accessDeniedHandler(
//                                new BearerTokenAccessDeniedHandler())
//                )
//                .build();
//    }
@Bean
public SecurityFilterChain securityFilterChain(
        final HttpSecurity http
) throws Exception {
    return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.GET, "/api/tours/**").permitAll()
                    .requestMatchers("/api/auth/**").permitAll()
                    .anyRequest().authenticated()
            )
            .sessionManagement(session ->
                    session.sessionCreationPolicy(STATELESS))
            .oauth2ResourceServer(server -> server
                    .jwt(Customizer.withDefaults())
                    .authenticationEntryPoint(
                            new BearerTokenAuthenticationEntryPoint())
                    .accessDeniedHandler(
                            new BearerTokenAccessDeniedHandler())
            )
            .build();
}

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}

