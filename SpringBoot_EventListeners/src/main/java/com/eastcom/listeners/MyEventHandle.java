package com.eastcom.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.eastcom.event.CustomEvent;
//@Component
public class MyEventHandle {
	
	@EventListener
	public void listener(CustomEvent event) {
		System.out.println(this.getClass().getSimpleName()+"监听到 "+event.getSource());
	}
}
