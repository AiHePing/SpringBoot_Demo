package com.eastcom.runner;

import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("====================MyApplicationRunner================");
		System.out.println("order值： 1");
		System.out.println("原始参数："+Arrays.asList(args.getSourceArgs()));
		Set<String> keys = args.getOptionNames();
		for (String key : keys) {
			System.out.println("解析后的key: ["+key+"]  value: "+args.getOptionValues(key));
		}
		System.out.println("无OptionName的参数： "+args.getNonOptionArgs());
		System.out.println("=======================================================");
	}
}
