package com.phenix.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Application
 *
 * @author john
 * @since 2017-10-16
 */
@SpringBootApplication
public class SpringBootDockerApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootDockerApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment()
                                     .getActiveProfiles();

        for (String profile : activeProfiles) {
            System.out.println("active profile: " + profile);
        }
    }

    /**
     * enable CORS(Cross-Origin Resource Sharing) for all
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*");
                registry.addMapping("/customer/*")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowCredentials(true);
            }
        };
    }

}
