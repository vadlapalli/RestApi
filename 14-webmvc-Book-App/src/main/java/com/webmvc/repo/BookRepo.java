package com.webmvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webmvc.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
