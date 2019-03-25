package com.eastcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.eastcom.configuration.MyConfiguration_Properties;
import com.eastcom.configuration.MyConfiguration_Value;

/*
 * @SpringBootApplication是一个复合注解
 * 包括：
 * 		@ComponentScan：扫描当前包及其子包下被@Component、@Controller、@Service、@Repository注解标记的类并纳
 * 						入到spring容器中进行管理，相当于xml中的<context:component-scan>
 * 
 * 		@SpringBootConfiguration：继承自@Configuration,二者功能一致，标注当前类是配置类，并会将当前类中声明的一个或多个
 * 								@Bean注解标记的方法的实例纳入spring容器，实例名就是方法名，可以通过@Bean指定实例名
 * 
 * 		@EnableAutoConfiguration：该注解的作用是启用自动配置，意思就是springboot根据你添加的jar包来配置你项目的默认配置
 * 
 * @SpringBootApplication注解相当于@ComponentScan、@Configuration、@EnableAutoConfiguration这三个注解，
 * 所以可用下面两个代替@SpringBootApplication注解，程序一样可以启动
 * 
 * --spring.config.location=classpath:/config/application.properties
 * --spring.config.location=file:E:\AllWorkSpace\custom.properties
 */
/**
 * @author:yaobiao
 * @date:2019年3月13日下午3:39:14
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		MyConfiguration_Value myConfiguration_Value = context.getBean(MyConfiguration_Value.class);
		System.out.println(myConfiguration_Value.toString());
		
		MyConfiguration_Properties myConfiguration_Properties = context.getBean(MyConfiguration_Properties.class);
		System.out.println(myConfiguration_Properties.toString());
		
		System.out.println(context.getEnvironment().getProperty("com.eastcom.index"));
		
		System.out.println(context.getEnvironment().getProperty("file.property"));
		System.out.println(context.getEnvironment().getProperty("file.list"));
		context.close();
	}
}
