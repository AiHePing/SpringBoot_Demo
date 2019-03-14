package com.eastcom.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @author:yaobiao
 * @date:2019年3月13日下午3:38:59
 */
@Component
public class MyConfiguration_Value {
	
	//@Value默认要有配置项，配置项可以为空，若没有配置项要指定默认值，:后的boot为默认值
	@Value("${com.eastcom.name:boot}")
	private String name;
	
	@Value("${com.eastcom.age}")
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
		return "MyConfiguration_Value [name=" + name + ", age=" + age + "]";
	}
}
