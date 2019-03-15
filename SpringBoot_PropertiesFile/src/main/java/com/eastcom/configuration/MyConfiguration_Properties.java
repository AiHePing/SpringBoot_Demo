package com.eastcom.configuration;

import java.util.List;

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
	
	private String version;
	
	private List<String> listName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public List<String> getListName() {
		return listName;
	}

	public void setListName(List<String> listName) {
		this.listName = listName;
	}

	@Override
	public String toString() {
		return "MyConfiguration_Properties [name=" + name + ", version=" + version + ", listName=" + listName + "]";
	}
	
}
