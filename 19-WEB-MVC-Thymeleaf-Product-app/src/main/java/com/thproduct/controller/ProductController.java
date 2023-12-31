package com.thproduct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thproduct.entity.Product;
import com.thproduct.repo.ProductRepo;


@Controller
public class ProductController {

	@Autowired
	private ProductRepo repo;

	@GetMapping("/")
	public String getProductPage(Model model) {
		
		/*
		 * p.setName("Hari"); p.setPrice(10000.0); p.setQty(3);
		 */
		model.addAttribute("product", new Product());
		return "index";
	}

	@PostMapping("/save")
	public String saveProductPage(@Validated Product p,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "index";
		}
		p = repo.save(p);
		if (p.getId() != null) {
			model.addAttribute("msg", "Data saved Successfully");
		}
		return "index";
	}
	@GetMapping("/products")
	public String getProducts(Model model) {
		List<Product> findAll = repo.findAll();
		//findAll.forEach(System.out::println);
		model.addAttribute("products", findAll);
		return "data";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id") Integer id, Model model) {
		repo.deleteById(id);	
		model.addAttribute("msg", "Product Deleted");
		model.addAttribute("products", repo.findAll());	
		return "data";
	}
	
	@GetMapping("/edit")	
	public String editProduct(@RequestParam("id") Integer id,Model model) {
		Optional<Product> findById = repo.findById(id);
		if(findById.isPresent()) {
			Product product = findById.get();
			model.addAttribute("product", product);
		}
		
		return "index";
	}

}
