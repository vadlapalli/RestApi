package com.producth2db.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.producth2db.Entity.Product;
import com.producth2db.Repo.ProductRepo;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepo repo;
	
	@GetMapping("/all")
	public String getAllProducts(Model model) {
		model.addAttribute("products", repo.findAll());
		return "data";
	}
	
	@GetMapping("/")
	public String loadPage(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}
	
	@PostMapping("/save")
	public String savePage(Product p,Model model) {
		repo.save(p);
		if(p.getId()!=null) {
			model.addAttribute("msg", "Data Saved");
		}
		System.out.println(p);
		return "index";
	}
}
