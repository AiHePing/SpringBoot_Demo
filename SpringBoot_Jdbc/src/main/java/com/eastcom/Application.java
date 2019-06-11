package com.eastcom;

import java.sql.Connection;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(Application.class);
		
		ConfigurableApplicationContext context = application.run(args);
		
		System.out.println("JdbcTemplate： "+context.getBean(JdbcTemplate.class));
//		System.out.println("NamedParameterJdbcTemplate: "+context.getBean(NamedParameterJdbcTemplate.class));
		System.out.println("DataSource： "+context.getBean(DataSource.class));
		DataSource dataSource = context.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println("Connection： "+connection);
	}
}
