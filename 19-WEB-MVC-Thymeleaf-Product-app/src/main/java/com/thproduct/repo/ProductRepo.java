package com.thproduct.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thproduct.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
