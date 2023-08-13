package com.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.Entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer>{

}
