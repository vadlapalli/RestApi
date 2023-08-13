package in.springbootDataJpa.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.springbootDataJpa.Entity.BookEntity;

public interface BookRepo extends CrudRepository<BookEntity, Integer> {
	
	public List<BookEntity> findByBookPriceGreaterThan(double bookPrice);
	
	public List<BookEntity> findByBookPriceLessThan(double bookPrice);
	
	List<BookEntity> findByBookPriceLessThanEqual(double bookPrice);
	
	@Query(value = "select * from book_entity", nativeQuery = true)
	public List<BookEntity> getAllBooks();


}
