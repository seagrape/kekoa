package com.sina.kekoa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试参数注入
 *
 */
//@Configuration
public class MyConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(@Qualifier("shanhyB") Shanhy shanhy) {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        shanhy.display();
        // 省略代码
        return filterRegistration;
    }
}