package in.springbootDataJpa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BookEntity {
	
	@Id
	private Integer bookId;
	private String bookName;
	private double bookPrice;

}
