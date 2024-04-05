package com.uw.cs506.team03.smartstock.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails James = User.builder().username("James").password("{noop}123").roles("EMPLOYEE").build();
//        UserDetails Jack = User.builder().username("Jack").password("{noop}321").roles("EMPLOYEE", "MANAGER").build();
//
//        return new InMemoryUserDetailsManager(James, Jack);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //allow user access those APIs
        //** means no matter what it is are allow
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/inventories").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/inventories/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/inventories").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/inventories/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/inventories/**").hasRole("MANAGER")
                );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

}
