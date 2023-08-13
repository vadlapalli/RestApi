package in.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMesg() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","Welcome to AshokIt...!");
		mav.setViewName("message");
		return mav;
	}
	
	@GetMapping("/greet")
	public ModelAndView getGreetMesg() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","Good Evening Hari");
		mav.setViewName("message");
		return mav;
	}

}
