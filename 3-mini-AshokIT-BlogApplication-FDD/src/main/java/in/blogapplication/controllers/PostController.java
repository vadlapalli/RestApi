package in.blogapplication.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.blogapplication.bindings.PostForm;
import in.blogapplication.services.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/post")
	public String postCreate(Model model) {
		model.addAttribute("postPage",new PostForm());
		return "post";
	}
	
	@PostMapping("/post")
	public String handlePostPage(@ModelAttribute("postPage") PostForm form,Model model) {
		Integer userId = (Integer)session.getAttribute("userId");
		boolean status=postService.postPage(form, userId);
		if(status) {
			model.addAttribute("succMsg", "Your Post is created successfully");
		}
		return "post";
	}
	
	@GetMapping("/postdashboard")
	public String postDashBoard(Model model) {
		return "postdashboard";
		
	}

}
