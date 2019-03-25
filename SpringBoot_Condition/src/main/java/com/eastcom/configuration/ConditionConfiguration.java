package com.eastcom.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;

import com.eastcom.bean.UserBean;
import com.eastcom.interfaces.condition_impl.GBKConditionImpl;
/*
 * Condition接口：里面只有一个方法，返回boolean值，true装配bean，false不装配bean
 * 
 * @Conditional：参数是实现了condition接口的类，通常这两个是一起配合使用，只有condition接口的实现类（一个或多个）都返回
 * true才装配，否则不装配，@Conditional注解还能用在类上，意味着对该类下所有方法起作用。
 * 
 * @ConditionalOnProperty：Name：配置名，HavingValue：当值为这个时生效，matchIfMissing：没有这个配置时是否装配，true为装配，否则不装配
 * 
 * @ConditionalOnClass：存在某个类是装配，也就是说类路径中有这个类就装配
 * 
 * @ConditionalOnBean：容器中有这个bean才装配
 * 
 *	 具体可以到org.springframework.boot.autoconfigure.condition包下查看其他condition，当springboot提供的
 * condition不满足我们的需求是，可以使用上面的方法实现condition接口，配合conditional注解使用，达到同样的效果
 */
@SpringBootConfiguration
public class ConditionConfiguration {
	@Autowired
	Environment env;
	
	@Bean
	@Conditional(GBKConditionImpl.class)
	public UserBean userBean() {
		return new UserBean();
	}
	//存在配置flag=true才装配
	@Bean
	@ConditionalOnProperty(name="flag",havingValue="true",matchIfMissing=true)
	public Runnable runnable() {
		return ()->{};
	}
	//指定类路径中存在ConfigurableApplicationContext类才装配
	@Bean
	@ConditionalOnClass(name="org.springframework.context.ConfigurableApplicationContext")
	public Runnable runnable2() {
		return ()->{};
	}
	//容器中存在UserBean才装配
	@Bean
	@ConditionalOnBean(UserBean.class)
	public Runnable runnable3() {
		return ()->{};
	}
}
