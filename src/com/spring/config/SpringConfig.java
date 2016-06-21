package com.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author lzc
 * 2016年3月18日下午2:16:02
 */
public class SpringConfig {
	
	public static ApplicationContext applicationContext;
	
	/*
	 * start spring container
	 */
	public static void start() {
		 applicationContext = new ClassPathXmlApplicationContext("conf/spring.xml");

	}

	
	
	public static void main(String[] args) {
		start();
	}
}
