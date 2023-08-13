package com.student.enquiries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
	
	@GetMapping("/")
	public Customer getCustomer() {
		Customer c = new Customer();
		c.setId(1);
		c.setName("John");
		c.setEmail("@john");
		c.setPhno(955003477);
		return c;
		
	}

}
