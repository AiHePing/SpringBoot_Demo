package com.eastcom.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.eastcom.interfaces.condition_impl.GBKConditionImpl;
import com.eastcom.interfaces.condition_impl.UTF8ConditionImpl;
import com.eastcom.interfaces.convent_impl.ConventGBKImpl;
import com.eastcom.interfaces.convent_impl.ConventUTF8Impl;
@SpringBootConfiguration
public class EncodingConventConfiguration {
	@Bean
	@Conditional(GBKConditionImpl.class)
	public ConventGBKImpl conventGBKImpl() {
		return new ConventGBKImpl();
	}
	
	@Bean 
	@Conditional(UTF8ConditionImpl.class)
	public ConventUTF8Impl conventUTF8Impl() {
		return new ConventUTF8Impl();
	}
}
