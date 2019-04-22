package com.eastcom.configuration;

import org.springframework.context.annotation.Bean;

import com.eastcom.bean.MyRunnable;
import com.eastcom.bean.UserBean;

public class ImportConfiguration {
	@Bean
	public UserBean userBean() {
		return new UserBean();
	}
	
	@Bean
	public MyRunnable myRunnable() {
		return new MyRunnable();
	}
}
