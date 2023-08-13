package io.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {



	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		Car car = context.getBean(Car.class);
		car.Drive();
		System.out.println(car.hashCode());
		
		Car c1 = context.getBean(Car.class);
		car.Drive();
		System.out.println(c1.hashCode());

	}

}
