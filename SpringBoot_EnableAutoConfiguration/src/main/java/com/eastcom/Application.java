package com.eastcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import com.eastcom.annotation.EnableEcho;
import com.eastcom.annotation.EnableFlag;
import com.eastcom.bean.ImportBean;
import com.eastcom.bean.MyRunnable;
import com.eastcom.configuration.ImportConfiguration;
/*
 * @Import：参数是class数组，表示导入一个或多个类，如果是配置类，里面的bean会被纳入spring容器
 * @EnableAsync：启用异步执行
 */
/**
 * @author:yaobiao
 * @date:2019年3月19日下午1:20:13
 */
//@Import({ImportBean.class,ImportConfiguration.class,MyRunnable.class})
@EnableAsync
@EnableFlag(value={ImportBean.class},strName="com.eastcom.configuration.ImportConfiguration")
@EnableEcho("com.eastcom.bean")
@ComponentScan
@EnableAutoConfiguration
//@EnableConfigurationProperties
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		/*context.getBean(Runnable.class).run();
		System.out.println(context.getBeansOfType(Runnable.class));*/
		System.out.println(context.getBean(ImportBean.class));
		System.out.println(context.getBean("ImportConfiguration"));
	}
}
//{ImportBean.class,ImportConfiguration.class}
//strName={"com.eastcom.bean.ImportBean","com.eastcom.configuration.ImportConfiguration"}