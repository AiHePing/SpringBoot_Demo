package com.eastcom.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * @author:yaobiao
 * @date:2019年3月13日下午3:39:07
 */
@Component
@ConfigurationProperties(prefix="com.eastcom")
public class MyConfiguration_Properties {
	
	private String name;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MyConfiguration_Properties [name=" + name + ", age=" + age + "]";
	}
}
