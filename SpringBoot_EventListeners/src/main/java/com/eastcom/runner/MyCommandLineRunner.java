package com.eastcom.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(2)
public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("====================MyCommandLineRunner================");
		System.out.println("order值： 2");
		System.out.println("原始参数： "+Arrays.asList(args));
		System.out.println("=======================================================");
	}
}
