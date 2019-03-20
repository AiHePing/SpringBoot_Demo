package com.eastcom.impl.beanRegistrar;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

import com.eastcom.annotation.EnableEcho;
import com.eastcom.annotation.EnableFlag;
import com.eastcom.impl.beanPostProcessor.EnableEchoBeanPostProcessor;

public class EnableEchoBeanRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Map<String, Object> map = importingClassMetadata.getAnnotationAttributes(EnableEcho.class.getName());
		List<String> list = Arrays.asList((String[])map.get("value"));
		
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(EnableEchoBeanPostProcessor.class);
		builder.addPropertyValue("packages", list);
		registry.registerBeanDefinition(builder.getBeanDefinition().getBeanClass().getSimpleName(), builder.getBeanDefinition());
	}
	
	private void register(BeanDefinitionRegistry registry,String type) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(type);
		String BeanClassName = builder.getBeanDefinition().getBeanClassName().substring(
				builder.getBeanDefinition().getBeanClassName().lastIndexOf(".")+1);
		System.out.println("========BeanClassName: "+BeanClassName);
		registry.registerBeanDefinition(BeanClassName, builder.getBeanDefinition());
	}
	
	private List<String> getList(AnnotationMetadata importingClassMetadata) {
		AnnotationAttributes attributes = getAttributes(importingClassMetadata);
		List<String> list = getAutoConfigurationList(importingClassMetadata,attributes);
		System.out.println("===========返回的list>>"+list);
		return list;
	}
	
	private AnnotationAttributes getAttributes(AnnotationMetadata annotationMetadata){
		String name = EnableFlag.class.getName();
		AnnotationAttributes attributes = AnnotationAttributes
				.fromMap(annotationMetadata.getAnnotationAttributes(name, true));
		return attributes;
	}
	
	private List<String> getAutoConfigurationList(AnnotationMetadata metadata,
			AnnotationAttributes attributes){
		List<String> data = new LinkedList<>();
		data.addAll(Arrays.asList(attributes.getStringArray("value")));
		return data;
	}
}
