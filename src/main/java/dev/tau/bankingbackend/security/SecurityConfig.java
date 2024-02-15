package dev.tau.bankingbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("ADMIN", "EMPLOYEE", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/customer").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/customer/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/customer").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/customer").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/customer/**").hasRole("ADMIN")
                );

        // use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF) as this is stateless REST API
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
