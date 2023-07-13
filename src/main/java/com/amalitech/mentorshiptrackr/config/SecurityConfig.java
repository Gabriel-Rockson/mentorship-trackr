package com.amalitech.mentorshiptrackr.config;

import com.amalitech.mentorshiptrackr.config.jwt.JWTAuthenticationFilter;
import com.amalitech.mentorshiptrackr.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class SecurityConfig {
    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    private final String ADMINISTRATOR_AUTHORITY = "Administrator";

    @Value("${api.endpoint.base-url}")
    private String baseUrl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authenticationProvider(authenticationProvider());
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(baseUrl + "/roles").hasAuthority(ADMINISTRATOR_AUTHORITY)
                        .requestMatchers(baseUrl + "/admins").hasAuthority(ADMINISTRATOR_AUTHORITY)
                        .requestMatchers(baseUrl + "/permissions").hasAuthority(ADMINISTRATOR_AUTHORITY)
                        .requestMatchers(baseUrl + "/advisees/**").hasAuthority(ADMINISTRATOR_AUTHORITY)
                        .requestMatchers(baseUrl + "/advisors/**").hasAuthority(ADMINISTRATOR_AUTHORITY)
                        .requestMatchers(baseUrl + "/authentication/token").permitAll()
                        .requestMatchers(baseUrl + "advisors/register-account").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return daoAuthenticationProvider;
    }

}
