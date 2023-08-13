package io.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext  context= new ClassPathXmlApplicationContext("Beans.xml");
		
      PaymentService service = context.getBean(PaymentService.class);
      service.doPayment(2555);

	}

}
