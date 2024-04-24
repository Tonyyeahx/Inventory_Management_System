package com.uw.cs506.team03.smartstock.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 允許所有來源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允許的HTTP方法
                .allowCredentials(false) // 允許Cookie
                .maxAge(3600); // 預檢的有效期，單位秒
    }
}