package io.spring.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		UserDao dao = context.getBean(UserDao.class);
		
		//for initilize method
		dao.getdata();
		
		
		//for destroy method
		ConfigurableApplicationContext cctxt=(ConfigurableApplicationContext)context;
		cctxt.close();
		

	}

}
