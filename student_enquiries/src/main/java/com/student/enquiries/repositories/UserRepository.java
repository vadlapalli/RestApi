package com.student.enquiries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.enquiries.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
	public Users findByEmail(String email);
	
	public Users findByEmailAndPassWord(String email,String passWord);
	
}
