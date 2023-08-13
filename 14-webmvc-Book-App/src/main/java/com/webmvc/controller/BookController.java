package com.webmvc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

import com.webmvc.entity.Book;
import com.webmvc.repo.BookRepo;


@Controller
public class BookController {
	
	@Autowired
	private BookRepo  repo;
	
	/*
	 * @GetMapping("/book") public ModelAndView getBookById(@RequestParam("id")
	 * Integer id) { System.out.println(id);
	 * 
	 * ModelAndView mav = new ModelAndView(); Optional<Book> byId =
	 * repo.findById(id); if(byId.isPresent()){ Book bookObj = byId.get();
	 * System.out.println(bookObj); //sending data to view
	 * mav.addObject("book",bookObj); } //setting view page name
	 * mav.setViewName("index"); return mav;
	 * 
	 * }
	 */
	
	@GetMapping("/book")
	public String getBookById(@RequestParam("id") Integer id, Model model) {
		Optional<Book> byId = repo.findById(id);
		if(byId.isPresent()){
			Book bookObj = byId.get();
			System.out.println(bookObj);
			model.addAttribute("book",bookObj);
		}
		return "index";
	}

}
