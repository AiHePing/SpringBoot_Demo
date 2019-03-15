package com.eastcom.envPropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;
/**
 * @author:yaobiao
 * @date:2019年3月13日下午5:35:05
 */
@Component
public class MyEnvironmentPropertySource implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("E:\\AllWorkSpace\\custom.properties"));
			
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			//第一个参数自定义
			PropertiesPropertySource propertySource = new PropertiesPropertySource("my", properties);
			environment.getPropertySources().addLast(propertySource);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
