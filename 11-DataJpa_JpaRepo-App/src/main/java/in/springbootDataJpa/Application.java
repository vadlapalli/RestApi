package in.springbootDataJpa;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import in.springbootDataJpa.entity.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		EmployeeRepo repo = run.getBean(EmployeeRepo.class);

		/*
		 * Employee e1=new Employee(1, "Bhavani", 75000.00, "Fe-Male", "Architect");
		 * Employee e2=new Employee(2, "Hari", 12500.00, "Male", "SM"); Employee e3=new
		 * Employee(3, "Babu", 165000.00, "Male", "CEO"); Employee e4=new Employee(4,
		 * "Vinitha", 25000.00, "Fe-Male", "CFO"); Employee e5=new Employee(5,
		 * "Srikanth", 45000.00, "Male", "TL"); Employee e6=new Employee(6, "Nehanth",
		 * 30000.00, "Male", "TM"); Employee e7=new Employee(7, "Nehanth", 35000.00,
		 * "Male", "TM"); repo.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7));
		 * System.out.println(repo.count());
		 */
		
		/*
		 * For Sorting Sort: descending = Sort.by("empSalary").descending();
		 * List<Employee> findAll = repo.findAll(descending);
		 * findAll.forEach(System.out::println);
		 */
		
		
		/*
		 * for Pagination: int pageNo = 3; PageRequest page = PageRequest.of(pageNo - 1,
		 * 3); Page<Employee> findAll2 = repo.findAll(page); List<Employee> content =
		 * findAll2.getContent(); content.forEach(System.out::println);
		 */
		

		/*
		 * System.out.println("=============================="); Sort ascending =
		 * Sort.by("empSalary").ascending(); List<Employee> find =
		 * repo.findAll(ascending); find.forEach(System.out::println);
		 */
		
		//Query By Example
		
		Employee emp= new Employee();
		emp.setEmpGender("Fe-Male");
		emp.setDept("CFO");

		Example<Employee> of = Example.of(emp);
		List<Employee> findAll = repo.findAll(of);
		findAll.forEach(System.out::println);
		
	}

}
