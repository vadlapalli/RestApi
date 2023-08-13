package io.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.spring.beans.Engine;

@Configuration
@ComponentScan(basePackages = {"io.spring","io.tcs"})
public class AppConfig {
	public AppConfig() {
		System.out.println("Config :: Constructor");
	}
	
	@Bean
	public Engine getEngine() {
		Engine eng=new Engine();
		return eng;
	}
	
}
