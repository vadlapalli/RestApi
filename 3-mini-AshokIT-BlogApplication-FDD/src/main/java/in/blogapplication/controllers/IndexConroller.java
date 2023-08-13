	package in.blogapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexConroller {
	
	@GetMapping("/")
	public String registrationPage() {
		return "index";
	}

}
