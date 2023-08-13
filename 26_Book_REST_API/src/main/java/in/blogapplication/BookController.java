package in.blogapplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@PostMapping(value="/book" , consumes = {"application/xml","application/json"})
	public ResponseEntity<String> addBook(@RequestBody Book b){
		System.out.println(b);
		//save data in db
		String msg="Book Added Successfully";
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/book", produces = {"application/xml","application/json"})
	public Book getbook() {
		
		Book b= new Book();
		b.setId(101);
		b.setName("Java");
		b.setPrice(130.00);
		return b;
	}

}
