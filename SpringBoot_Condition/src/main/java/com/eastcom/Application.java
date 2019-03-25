package com.eastcom;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.eastcom.bean.UserBean;
/**
 * @author:yaobiao
 * @date:2019年3月18日上午10:58:48
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class,args);
//		System.out.println("encoding:"+System.getProperty("file.encoding"));
//		System.out.println(context.getBean(IEncodingConvent.class).getClass());
		System.out.println(context.getBeansOfType(Runnable.class));
		try {
			System.out.println(context.getBean(UserBean.class));
		} catch (BeansException e) {
			e.printStackTrace();
		}
		context.close();
	}
}
//-Dfile.encoding=GBK