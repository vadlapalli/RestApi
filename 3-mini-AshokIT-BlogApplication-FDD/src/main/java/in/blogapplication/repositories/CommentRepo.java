package in.blogapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.blogapplication.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
