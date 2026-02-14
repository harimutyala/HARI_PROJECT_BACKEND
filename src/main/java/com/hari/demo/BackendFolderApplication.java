package com.hari.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendFolderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendFolderApplication.class, args);
		System.out.println("I am Starting..");
	}

	@org.springframework.context.annotation.Bean
	public org.springframework.web.servlet.config.annotation.WebMvcConfigurer corsConfigurer() {
		return new org.springframework.web.servlet.config.annotation.WebMvcConfigurer() {
			@Override
			public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:5173", "http://localhost:3000", "*") // Explicitly allowing
																								// frontend port
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*");
			}
		};
	}

	@org.springframework.context.annotation.Bean
	public org.springframework.boot.CommandLineRunner commandLineRunner(
			org.springframework.context.ApplicationContext ctx) {
		return args -> {
			System.out.println("INSPECTING BEANS:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			java.util.Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				if (beanName.toLowerCase().contains("controller")) {
					System.out.println("BEAN: " + beanName);
				}
			}
		};
	}

}
