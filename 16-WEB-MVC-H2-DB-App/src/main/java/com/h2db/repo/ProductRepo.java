package com.h2db.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2db.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	

}
