package com.ABML.ABML;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AbmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbmlApplication.class, args);
	}
        
        @Bean
	public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("https://portfolio-lucas-ap.web.app");
		}
            };
	}

}
