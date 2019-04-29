package com.eastcom.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Component
public class OldWebMvcConfiguration extends WebMvcConfigurationSupport{
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/hh/");
		super.addResourceHandlers(registry);
	}
}
