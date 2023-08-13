package com.student.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Entity.StudentEntity;
import com.student.binding.Student;
import com.student.repo.StudentRepo;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	public boolean saveStudent(Student s) {
		
		StudentEntity entity=new StudentEntity();
		BeanUtils.copyProperties(s, entity);
		//entity.setTimings(Arrays.toString(s.getTimings()));
		System.out.println(entity);
		repo.save(entity);
		return false;
		
	}
	
	public List<String> getCourses(){
		return Arrays.asList("Java","Python","C#");
	}
	
	public List<String> getTimings(){
		return Arrays.asList("Morning","Afterrnoon","Evening");
	}

}
