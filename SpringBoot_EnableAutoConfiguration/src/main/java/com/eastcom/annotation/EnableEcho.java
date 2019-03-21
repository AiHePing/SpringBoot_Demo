package com.eastcom.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.eastcom.impl.beanRegistrar.EnableEcho_BeanRegistrar;

/**
 * 自定义注解，打印bean信息
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(EnableEcho_BeanRegistrar.class)
public @interface EnableEcho {
	/**
	 * 指定包
	 * @return
	 */
	String[] value() default {};
}
