package dev.tau.bankingbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // Add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/customer").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/customer/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/customer").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/customer/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/customer/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/transaction").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/transaction/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/transaction").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/transaction/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/transaction/**").hasRole("ADMIN")
                );

        // use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF) as this is stateless REST API
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }


//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("ADMIN", "EMPLOYEE", "MANAGER")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }
}
