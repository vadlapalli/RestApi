package in.blogapplication.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.blogapplication.bindings.PostForm;
import in.blogapplication.entities.Post;
import in.blogapplication.entities.UserDtls;
import in.blogapplication.repositories.PostRepo;
import in.blogapplication.repositories.UserRepo;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private HttpSession session;
	
	
	@Override
	public boolean postPage(PostForm form,Integer userId) {
		// TODO get the user id from user repo
		UserDtls user=userRepo.findById(userId).get();
		System.out.println(user);
		// TODO copy data from form to object
		Post posts=new Post();
		BeanUtils.copyProperties(form, posts);
		
		//TODO save post data into database
		posts.setUser(user);
		postRepo.save(posts);
		
		return true;
	}
	
	@Override
	public List<Post> getAllPosts() {
		// TODO get userid
		Integer userId=(Integer) session.getAttribute("userId");
		Optional<UserDtls> findById=userRepo.findById(userId);
		if(findById.isPresent()) {
			UserDtls userDtls=findById.get();
			List<Post> posts=userDtls.getPosts();
			return posts;
			
		}
		return null;
		
	}
	/*
	 * @Override public void deletePost(Integer postId) {
	 * postRepo.softDelete(postId);
	 * 
	 * }
	 */
}
