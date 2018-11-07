package com.dmytro.andrusiv.velostok.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//    for developing only
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//    for production
//    registry.addMapping("/**").allowedMethods("GET", "POST","PUT", "DELETE", "OPTIONS")
//        .allowedOrigins(environment.getRequiredProperty("allow.origin.local"),environment.getRequiredProperty("allow.origin.global"));
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}
