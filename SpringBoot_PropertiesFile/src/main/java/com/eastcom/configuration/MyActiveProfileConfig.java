package com.eastcom.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/*
 * @Profile：当设置的properties配置文件加载后才装配这个bean，还可以用在类上，同理
 */
/**
 * @author:yaobiao
 * @date:2019年3月13日下午6:07:57
 */
@Configuration
public class MyActiveProfileConfig {
	
	@Bean
	public Runnable create() {
		System.out.println("default");
		return ()->{};
	}
	
	@Bean
	@Profile("dev")
	public Runnable createDev() {
		System.out.println("dev");
		return ()->{};
	}
	
	@Bean
	@Profile("prod")
	public Runnable createProd() {
		System.out.println("prod");
		return ()->{};
	}
	
	@Bean
	@Profile("test")
	public Runnable createTest() {
		System.out.println("test");
		return ()->{};
	}
}
