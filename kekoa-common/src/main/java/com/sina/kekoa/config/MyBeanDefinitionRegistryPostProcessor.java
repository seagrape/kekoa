package com.sina.kekoa.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

/**
 * 实现自己实例化bean并注册为Spring管理
 *
 */
//@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements
		BeanDefinitionRegistryPostProcessor {

	private static final Logger logger = LoggerFactory.getLogger(MyBeanDefinitionRegistryPostProcessor.class);

	private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();
	private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		logger.info("Invoke Metho postProcessBeanFactory");
		// 这里可以设置属性，例如
//		BeanDefinition bd = beanFactory.getBeanDefinition("dataSourceA");
//		MutablePropertyValues mpv = bd.getPropertyValues();
//		mpv.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");
//		mpv.addPropertyValue("url", "jdbc:mysql://localhost:3306/test");
//		mpv.addPropertyValue("username", "root");
//		mpv.addPropertyValue("password", "123456");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		logger.info("Invoke Metho postProcessBeanDefinitionRegistry");
		registerBean(registry, "shanhyA", ShanhyA.class);
		registerBean(registry, "shanhyB", ShanhyB.class);
//		registerBean(registry, "dataSourceA",org.apache.tomcat.jdbc.pool.DataSource.class);
	}

	private void registerBean(BeanDefinitionRegistry registry, String name,Class<?> beanClass) {
		AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(beanClass);

		ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
		abd.setScope(scopeMetadata.getScopeName());
		// 可以自动生成name
		String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(abd, registry));

		AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);

		BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd,beanName);
		BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder,registry);
	}
}