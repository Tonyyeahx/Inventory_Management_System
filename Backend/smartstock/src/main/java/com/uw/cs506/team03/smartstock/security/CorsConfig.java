package com.uw.cs506.team03.smartstock.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class is used to configure CORS
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * This method is used to configure CORS
     * @param registry the CORS registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all paths
                .allowedOrigins("*")  // Allow all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow all methods
                .allowCredentials(false) // Do not allow credentials
                .maxAge(3600); // Set max age to 3600 seconds
    }
}