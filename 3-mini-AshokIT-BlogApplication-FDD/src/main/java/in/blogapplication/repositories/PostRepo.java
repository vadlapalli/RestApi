package in.blogapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.blogapplication.entities.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	/*
	 * @Query("update{Post} post set post.deleteFlag=true where post.postid=?1")
	 * 
	 * @Modifying public Post softDelete(Integer postid);
	 */
	

}
