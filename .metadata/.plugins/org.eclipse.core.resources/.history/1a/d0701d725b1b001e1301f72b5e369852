package in.springbootDataJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.springbootDataJpa.impl.Demo;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext cxt=SpringApplication.run(Application.class, args);
		
		Demo bean = cxt.getBean(Demo.class);
		bean.m1();
		
	}

}
