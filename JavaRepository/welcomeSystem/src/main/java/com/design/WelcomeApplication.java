package com.design;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.design.mapper")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class WelcomeApplication {
	public static void main(String[] args) {
		SpringApplication.run(WelcomeApplication.class);
	}
}
