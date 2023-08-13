package in.hari;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	@GetMapping("/user")
	public String getUser() {
		User user = new User();
		user.setId(1);
		user.setName("Madhu");
		user.setEmail("hari@gmail.com");
		return "User retrived sccessflly:"+ user;
	}

}
