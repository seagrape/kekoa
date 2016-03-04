package com.sina.kekoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan//(basePackages="com.sina.kekoa.demo")

//@EnableAutoConfiguration
//@EntityScan//("com.sina.kekoa.demo")
//@EnableJpaRepositories//("com.sina.kekoa.demo")
public class KekoaApplication {

	public static void main(String[] args) {
        SpringApplication.run(KekoaApplication.class, args);
    }
	
}
