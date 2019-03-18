package com.eastcom.interfaces.condition_impl;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class UTF8ConditionImpl implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//获取文件属性，如果是utf-8就返回true，装配UTF8ConditionImpl；否则就是false，不装配
		String encode = System.getProperty("file.encoding");
		if (encode.toLowerCase().equals("utf-8")) {
			return true;
		}
		return false;
	}
}
