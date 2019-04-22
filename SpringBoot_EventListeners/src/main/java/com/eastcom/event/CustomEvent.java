package com.eastcom.event;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	public CustomEvent(Object source) {
		super(source);
	}
}
