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

/**
 * This class is used to configure security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * This is the default constructor for the SecurityConfig class
     */
    public SecurityConfig() {
    }

    /**
     * This method is used to create a UserDetailsManager
     * @param dataSource the data source
     * @return the UserDetailsManager
     */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //allow user access those APIs
        //** means no matter what it is are allow
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        //inventories APIs
                        .requestMatchers(HttpMethod.GET, "/filterInventories/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/inventories").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/inventories/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/inventories").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/inventories/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/inventories/**").hasRole("MANAGER")
                        //suppliers APIs
                        .requestMatchers(HttpMethod.GET, "/suppliers").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/suppliers/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/suppliers").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/suppliers/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/suppliers/**").hasRole("MANAGER")
                        //categories APIs
                        .requestMatchers(HttpMethod.GET, "/categories").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/categories/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/categories").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/categories/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/categories/**").hasRole("MANAGER")
                        //stores APIs
                        .requestMatchers(HttpMethod.GET, "/stores").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/stores/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/stores").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/stores/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/stores/**").hasRole("MANAGER")
                        //products APIs
                        .requestMatchers(HttpMethod.GET, "/products").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/products/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/products").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/products/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/products/**").hasRole("MANAGER")
                        //login APIs
                        .requestMatchers(HttpMethod.POST, "/login/adduser").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/users/test/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/login").hasRole("EMPLOYEE")
                        //financial metric APIs
                        .requestMatchers(HttpMethod.GET, "/greatestCost/**").hasRole("MANAGER")

                );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }



}
