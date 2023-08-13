package in.springbootDataJpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

import in.springbootDataJpa.Entity.BookEntity;
import in.springbootDataJpa.Repo.BookRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		BookRepo bean = context.getBean(BookRepo.class);

		/*
		 * BookEntity b = new BookEntity(); b.setBookId(102); b.setBookName("Python");
		 * b.setBookPrice(1500.00);
		 * 
		 * BookEntity b2 = new BookEntity(); b2.setBookId(103);
		 * b2.setBookName("Docker"); b2.setBookPrice(3000.00);
		 * 
		 * BookEntity b3 = new BookEntity(); b3.setBookId(104); b3.setBookName("C#");
		 * b3.setBookPrice(1500.00);
		 * 
		 * BookEntity b4 = new BookEntity(); b4.setBookId(105); b4.setBookName("XMl");
		 * b4.setBookPrice(2700.00);
		 * 
		 * BookEntity b5 = new BookEntity(); b5.setBookId(106); b5.setBookName("C");
		 * b5.setBookPrice(1500.00);
		 * 
		 * 
		 * List<BookEntity> book=new ArrayList<>(); book.add(b); book.add(b5);
		 * book.add(b4); book.add(b3); book.add(b2);
		 * 
		 * 
		 * bean.saveAll(Arrays.asList(b, b2, b3, b4, b5));
		 * System.out.println(bean.existsById(102)); System.out.println(bean.count());
		 * 
		 * Optional<BookEntity> findById = bean.findById(101);
		 * System.out.println(findById);
		 * 
		 * Iterable<BookEntity> findAllById = bean.findAllById(Arrays.asList(101, 102,
		 * 103));
		 * 
		 * for (BookEntity book : findAllById) { System.out.println(book); }
		 * 
		 * bean.deleteById(106);
		 */
			List<BookEntity> findByBookGreaterThanPrice = bean.findByBookPriceGreaterThan(1500);
			
			for(BookEntity b : findByBookGreaterThanPrice) {
				System.out.println(b);
				
			}
			
			List<BookEntity> findByBookPriceLessThan = bean.findByBookPriceLessThan(1500);
			for(BookEntity b1 : findByBookPriceLessThan) {
				System.out.println(b1);
				
			}
			
			/*
			 * List<BookEntity> findByBookPriceLessThanOrEqualt =
			 * bean.findByBookPriceLessThanOrEqual(1500);
			 * 
			 * for(BookEntity b2 : findByBookPriceLessThanOrEqualt) {
			 * System.out.println(b2);
			 * 
			 * }
			 */
			
			List<BookEntity> findByBookPriceLessThanOrEqual = bean.findByBookPriceLessThanEqual(1500);
			
			for(BookEntity b2 : findByBookPriceLessThanOrEqual) {
				System.out.println(b2);
			}
			
			
			List<BookEntity> allBooks = bean.getAllBooks();
			allBooks.forEach(System.out::println);
	}

}
