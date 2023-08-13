package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.binding.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;


	@GetMapping("/")
	public String loadIndexPage(Model model) {
		// sobj.setEmail("harivadlapalli1a@gmail.com");
		formInitBinding(model);
		return "index";
	}
	
	//@InitBinder
	private void formInitBinding(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses",service.getCourses());
		model.addAttribute("preTimings",service.getTimings());
	}

	@PostMapping("/save")
	public String handleSubmitBtn(Model model, Student s) {
		System.out.println(s);
		service.saveStudent(s);
		model.addAttribute("msg","Data saved successfully....");
		formInitBinding(model);
		return "index";
	}

}
