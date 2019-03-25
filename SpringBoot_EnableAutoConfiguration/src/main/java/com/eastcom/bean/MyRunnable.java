package com.eastcom.bean;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;

public class MyRunnable implements Runnable {

	@Async//异步执行
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println("=========>"+i);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
		}
	}

}
