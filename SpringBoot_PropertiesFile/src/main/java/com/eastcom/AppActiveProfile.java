package com.eastcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppActiveProfile {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AppActiveProfile.class);
//		application.setAdditionalProfiles("dev","prod");
		ConfigurableApplicationContext context = application.run(args);
		context.close();
	}
}
