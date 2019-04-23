package com.eastcom;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application{
	public static void main(String[] args) {
		
		SpringApplication application = new SpringApplication(Application.class);
		
		ConfigurableApplicationContext context = application.run(args);
		
		ApplicationArguments arguments = context.getBean(ApplicationArguments.class);
//		ApplicationFailedEvent event = new ApplicationFailedEvent(application,
//				args, context, new RuntimeException());
//		context.publishEvent(event);
		System.out.println(context.getEnvironment().getPropertySources().get("commandLineArgs").getProperty("spring.config.location"));
		System.out.println("name:"+arguments.getOptionNames()+" , value："+arguments.getOptionValues("spring.config.location"));
//		context.close();
		
		
	}
}
