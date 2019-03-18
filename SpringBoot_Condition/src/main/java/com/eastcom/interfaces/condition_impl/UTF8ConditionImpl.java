package com.eastcom.interfaces.condition_impl;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UTF8ConditionImpl implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encode = System.getProperty("file.encoding");
		if (encode.toLowerCase().equals("utf-8")) {
			return true;
		}
		return false;
	}

}
