package in.blogapplication.services;

import java.util.List;

import in.blogapplication.bindings.PostForm;
import in.blogapplication.entities.Post;

public interface PostService {
	
	public boolean postPage(PostForm form,Integer userId);
	
	List<Post> getAllPosts();
	
	//public void deletePost(Integer postId);
	
}