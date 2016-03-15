package com.sina.kekoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.sina.kekoa.datasource.DynamicDataSourceRegister;

@SpringBootApplication
@ComponentScan//(basePackages="com.sina.kekoa.demo")
@Import(DynamicDataSourceRegister.class)
//@EnableAutoConfiguration
//@EntityScan//("com.sina.kekoa.demo")
//@EnableJpaRepositories//("com.sina.kekoa.demo")
public class KekoaApplication  {

	public static void main(String[] args) {
        SpringApplication.run(KekoaApplication.class, args);
    }
	
}
