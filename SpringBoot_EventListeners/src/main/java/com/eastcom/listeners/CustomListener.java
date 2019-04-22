package com.eastcom.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.eastcom.event.CustomEvent;
//@Component
public class CustomListener implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent event) {
		System.out.println(this.getClass().getSimpleName()+"监听到 "+event.getSource());
	}

}
