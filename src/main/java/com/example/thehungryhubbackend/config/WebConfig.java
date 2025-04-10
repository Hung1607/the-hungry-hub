package com.example.thehungryhubbackend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private final CorsConfiguration corsConfiguration;

    public WebConfig(CorsConfiguration corsConfiguration) {
        this.corsConfiguration = corsConfiguration;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(corsConfiguration.getAllowedOrigins().getFirst())
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @ConfigurationProperties(prefix = "thehungryhub.cors")
    @Validated
    @Configuration
    public static class CorsConfiguration {

        private List<String> allowedOrigins;

        public List<String> getAllowedOrigins(){
            return allowedOrigins;
        }

        public void setAllowedOrigins(List<String> allowedOrigins){
            this.allowedOrigins = allowedOrigins;
        }
    }

}
