package in.welcomeapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.welcomeapi.feign.GreetFeignClient;

@RestController
public class WelcomeRestController {
	
	@Autowired
	private GreetFeignClient feignClient;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String feignRes =feignClient.invokGreetMsg();
		return feignRes + ",Welcome To AshokIT";
	}

}
