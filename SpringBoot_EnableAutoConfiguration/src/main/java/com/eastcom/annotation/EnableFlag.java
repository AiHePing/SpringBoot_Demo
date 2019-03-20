package com.eastcom.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.eastcom.impl.beanRegistrar.EnableFlagBeanRegistrar;
import com.eastcom.impl.importSelector.EnableFlagImportSelector;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
//@Import(EnableFlagImportSelector.class)//ImportSelector方式
@Import(EnableFlagBeanRegistrar.class)//ImportBeanDefinitionRegistrar方式
public @interface EnableFlag {
	String[] strName() default {};
	Class<?>[] value() default {};
}
