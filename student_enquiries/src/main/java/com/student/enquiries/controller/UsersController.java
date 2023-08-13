package com.student.enquiries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.enquiries.binding.LoginForm;
import com.student.enquiries.binding.SignUpForm;
import com.student.enquiries.binding.UnlockForm;
import com.student.enquiries.constant.AppConstants;
import com.student.enquiries.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService service;

	@GetMapping("/signup")
	public String getSignupPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		return "signup";
	}

	@PostMapping("/signup")
	public String handleSignUp(@ModelAttribute("user") SignUpForm form, Model model) {
		boolean status = service.signup(form);

		if (status) {
			model.addAttribute(AppConstants.STR_SUCCESS_MSG, "Check Your Email");
		} else {

			model.addAttribute(AppConstants.STR_ERROR_MSG, "Choose Unique Email");
		}

		return "signup";

	}

	@GetMapping("/unlock")
	public String getUnlockPage(@RequestParam String email, Model model) {

		UnlockForm unlockFormObj = new UnlockForm();
		unlockFormObj.setEmail(email);
		model.addAttribute(AppConstants.UNLOCK_STR, unlockFormObj);
		return AppConstants.UNLOCK_STR;
	}

	@PostMapping("/unlock")
	public String unlockUserAccount(@ModelAttribute("unlock") UnlockForm unlock, Model model) {

		if (unlock.getNewPwd().equals(unlock.getConfirmPwd())) {
			
			boolean status = service.unlockAcct(unlock);
			if (status) {
				model.addAttribute(AppConstants.STR_SUCCESS_MSG, "Your account unlocked successfully");
			} else {

				model.addAttribute(AppConstants.STR_ERROR_MSG, "Given Temporary Pwd is incorrect,check your email");

			}

		} else {

			model.addAttribute(AppConstants.STR_ERROR_MSG, "New Pwd and Confirm Pwd should be Same");
		}

		return AppConstants.UNLOCK_STR;
	}

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@PostMapping("/login")
	public String loginForm(@ModelAttribute("loginForm") LoginForm form, Model model) {
		String status=service.loginForm(form);
		if(status.contains("Success")) {
			
			//Display dashboard
			
			return"redirect:/dashboard";
			
		}
		
		model.addAttribute(AppConstants.STR_ERROR_MSG, status);
		
		return "login";
	}

	@GetMapping("/forgot")
	public String forgotPwdPage() {

		return "forgotPwd";
	}
	
	
	@PostMapping("/forgotPwd")
	public String forgotPwd(@RequestParam("email") String email,Model model) {
		boolean status=service.forgotPwd(email);
		
		if(status){
			
			model.addAttribute(AppConstants.STR_SUCCESS_MSG,"Pwd sent to your mail");
			
		}else {
			
			model.addAttribute(AppConstants.STR_ERROR_MSG,"Invalid Email");
			
		}
		return "forgotPwd";
	}
}
