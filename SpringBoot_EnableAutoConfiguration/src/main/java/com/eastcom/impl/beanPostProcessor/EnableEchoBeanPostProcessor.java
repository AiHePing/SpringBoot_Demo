package com.eastcom.impl.beanPostProcessor;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EnableEchoBeanPostProcessor implements BeanPostProcessor {
	
	private List<String> packages;
	
	public List<String> getPackages() {
		return packages;
	}
	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		for (String string : packages) {
			if (bean.getClass().getName().startsWith(string)) {
				System.out.println("=============>>echo " + bean.getClass().getName() + ": " +beanName);
			}
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}
