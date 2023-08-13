package io.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.spring.config.AppConfig;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext cnxt = new AnnotationConfigApplicationContext(AppConfig.class);

	}

}
