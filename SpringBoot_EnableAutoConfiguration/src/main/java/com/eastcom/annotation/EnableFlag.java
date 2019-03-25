package com.eastcom.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.eastcom.impl.beanRegistrar.EnableFlag_BeanRegistrar;
import com.eastcom.impl.importSelector.EnableFlag_ImportSelector;

/**
 * 自定义注解，装配bean
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
//@Import(EnableFlag_ImportSelector.class)
@Import(EnableFlag_BeanRegistrar.class)
public @interface EnableFlag {
	
	/**
	 * bean的完全限定名称
	 * @return
	 */
	String[] strName() default {};
	
	/**
	 * bean的class对象
	 * @return
	 */
	Class<?>[] value() default {};
}
//ImportSelector方式,名字是类名第一个字母小写，两种参数方式都行
//ImportBeanDefinitionRegistrar方式两种参数方式都行，名字就是类名