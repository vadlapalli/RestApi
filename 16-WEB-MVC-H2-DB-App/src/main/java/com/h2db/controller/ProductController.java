package com.h2db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	
	@GetMapping("/")
	public String getForm() {
		return "index";
	}

}
