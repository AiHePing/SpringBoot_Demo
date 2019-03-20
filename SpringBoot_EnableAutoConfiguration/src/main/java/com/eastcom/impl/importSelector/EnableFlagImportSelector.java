package com.eastcom.impl.importSelector;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import com.eastcom.annotation.EnableFlag;

public class EnableFlagImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println("=========获取的注解信息>>"+importingClassMetadata.getAnnotationAttributes(EnableFlag.class.getName()));
		return StringUtils.toStringArray(getList(importingClassMetadata));
	}
	
	private List<String> getList(AnnotationMetadata importingClassMetadata) {
		AnnotationAttributes attributes = getAttributes(importingClassMetadata);
		List<String> list = getAutoConfigurationList(importingClassMetadata,attributes);
		System.out.println("===========返回的list>>"+list);
		return list;
	}
	/**
	 * 
	 * getAnnotationAttributes(String annotationName,boolean classValuesAsString):检索给定类型的注释的属性
	 * annotationName:要查找的注释类型的完全限定类名
	 * classValuesAsString:是否将类引用转换为String类名，以便在返回的Map中将值作为值转换，而不是可能必须首先加载的类引用
	 * 
	 * fromMap(Map<String,Object>):根据给定的Map返回AnnotationAttributes实例。
	 * @return
	 */
	private AnnotationAttributes getAttributes(AnnotationMetadata annotationMetadata){
		String name = EnableFlag.class.getName();
		AnnotationAttributes attributes = AnnotationAttributes
				.fromMap(annotationMetadata.getAnnotationAttributes(name, true));
		return attributes;
	}
	/**
	 * 获取注解属性值
	 * @param metadata
	 * @param attributes
	 * @return
	 */
	private List<String> getAutoConfigurationList(AnnotationMetadata metadata,
			AnnotationAttributes attributes){
		List<String> data = new LinkedList<>();
		data.addAll(Arrays.asList(attributes.getStringArray("strName")));
		data.addAll(asList(attributes, "value"));
		return data;
	}
	
	protected final List<String> asList(AnnotationAttributes attributes, String name) {
		String[] value = attributes.getStringArray(name);
		return Arrays.asList((value != null) ? value : new String[0]);
	}
}
