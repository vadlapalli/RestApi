package com.producth2db.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producth2db.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
