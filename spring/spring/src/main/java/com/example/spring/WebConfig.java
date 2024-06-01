package com.example.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The WebConfig class implements the WebMvcConfigurer interface to provide custom configuration
 * for Spring MVC. Specifically, it configures Cross-Origin Resource Sharing (CORS) settings.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures CORS mappings.
     *
     * This method allows requests from the specified origins with the specified HTTP methods
     * and headers. The configuration is applied to all paths (/**).
     *
     * @param registry The CorsRegistry to add mappings to.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
