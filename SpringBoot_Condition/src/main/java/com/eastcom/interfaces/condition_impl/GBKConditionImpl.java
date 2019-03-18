package com.eastcom.interfaces.condition_impl;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class GBKConditionImpl implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String encode = System.getProperty("file.encoding");
		if (encode.toLowerCase().equals("gbk")) {
			return true;
		}
		return false;
	}

}
