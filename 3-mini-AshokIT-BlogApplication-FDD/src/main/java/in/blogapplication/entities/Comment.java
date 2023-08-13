package in.blogapplication.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
 
@Setter
@Getter
@Entity
@Table
public class Comment {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	
	@Lob
	private String comment;
	
	@CreationTimestamp
	private LocalDate createdOn;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;

}
