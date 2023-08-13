package in.hari._jackson_app;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonConvertor {

	public static void main(String[] args) throws Exception {
		
		/*Customer c= new Customer();
		
		c.setId(1);
		c.setName("Hari");
		c.setEmail("@gmail.com");
		c.setPhno(955003);*/
		
		ObjectMapper mapper=new ObjectMapper();
		/*mapper.writeValue(new File("customer.json"), c);
		System.out.println("Json file generated");*/
		
		File f =new File("customer.json");
		
		Customer c1 = mapper.readValue(f, Customer.class);
		
		System.out.println(c1);
	}

}
