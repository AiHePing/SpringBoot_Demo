package com.eastcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.eastcom.event.CustomEvent;
import com.eastcom.listeners.CustomListener;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		//第一种方式
//		application.addListeners(new MyApplicationListener());
		ConfigurableApplicationContext context = application.run(args);
		context.publishEvent(new CustomEvent("CustomEvent 事件"));
	}

}
