package com.eastcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.eastcom.bean.UserBean;
import com.eastcom.interfaces.IEncodingConvent;

/**
 * @author:yaobiao
 * @date:2019年3月18日上午10:58:48
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println(System.getProperty("file.encoding"));
		System.out.println(context.getBean(IEncodingConvent.class).getClass());
		System.out.println(context.getBean(UserBean.class));
		
		context.close();
	}

}
