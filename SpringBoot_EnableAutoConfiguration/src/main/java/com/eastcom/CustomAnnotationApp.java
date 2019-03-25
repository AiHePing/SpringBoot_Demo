package com.eastcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.eastcom.annotation.EnableFlag;
import com.eastcom.bean.ImportBean;
import com.eastcom.bean.UserBean;

@EnableFlag(value={ImportBean.class},strName="com.eastcom.configuration.ImportConfiguration")
@SpringBootApplication
public class CustomAnnotationApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CustomAnnotationApp.class, args);
		System.out.println(context.getBean(ImportBean.class));
		System.out.println(context.getBean("importConfiguration"));
		System.out.println(context.getBean(UserBean.class));
		System.out.println(context.getBeansOfType(Runnable.class));
	}
}
