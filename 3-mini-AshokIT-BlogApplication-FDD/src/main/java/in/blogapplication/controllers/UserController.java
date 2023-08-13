package in.blogapplication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.blogapplication.bindings.LoginForm;
import in.blogapplication.bindings.RegisterForm;
import in.blogapplication.entities.Post;
import in.blogapplication.repositories.PostRepo;
import in.blogapplication.services.PostService;
import in.blogapplication.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostRepo postRepo;
	
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/register")
	public String indexPage(Model model) {
		model.addAttribute("user",new RegisterForm());
		return "registrationPage";
	}
	
	@PostMapping("/register")
	public String indexPageHandler(@ModelAttribute("user")  RegisterForm form,Model model) {
		boolean status=userService.registration(form);
		if(status) {
			model.addAttribute("succMsg", "Your Registration is success");
		}else {
			model.addAttribute("errMsg", "Choose Unique Email");
		}
		return "registrationPage";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm",new LoginForm());
		return "loginPage";
	}
	
	@PostMapping("/login")
	public String loginForm(@ModelAttribute("loginForm") LoginForm form, Model model) {
		
		String status=userService.login(form);
		

		// System.out.println(status);
		
		if(status.contains("Success")) {
			return "redirect:/userdashboard";	
			
		}else {
		
		model.addAttribute("errMsg", status);
		}
		model.addAttribute("loginForm", new LoginForm());
		return "loginPage";
	}
	
	@GetMapping("/userdashboard")
	public String viewBlog(Model model) {
		List<Post> posts=postService.getAllPosts();
		model.addAttribute("posts",posts);
		return "userdashboard";
	}
	
	@GetMapping("/posts")
	public String getPosts(Model model) {
		List<Post> posts=postService.getAllPosts();
		model.addAttribute("posts",posts);
		return "allposts";
	}
	
	@GetMapping("/edit")
	public String editPost(@RequestParam("postId") Integer postId,Model model) {
		Post post = postRepo.findById(postId).get();
		model.addAttribute("postPage", post);
		return "post";

	} 
	/*
	 * @GetMapping("/delete") public String deletePost(@RequestParam("postId")
	 * Integer postId,Model model) { Post post=postRepo.softDelete(postId);
	 * model.addAttribute("postPage",post); return "post";
	 * 
	 * }
	 */
	
}
