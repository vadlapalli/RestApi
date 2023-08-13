package in.hari;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/welcome")
	public String getMesg() {
		String msg="Welcome to Rest Api...!";
		return msg;
	}
	
	@PostMapping("/msg")
	public ResponseEntity<String> sveMsg(){
		String responseBody="msg saved succussfully";
		return new ResponseEntity<String>(responseBody,HttpStatus.CREATED);
	}

}
