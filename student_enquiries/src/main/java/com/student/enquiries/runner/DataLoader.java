package com.student.enquiries.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.student.enquiries.entities.Course;
import com.student.enquiries.entities.EnquiryStatus;
import com.student.enquiries.repositories.CourseRepo;
import com.student.enquiries.repositories.StatusRepo;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private StatusRepo statusRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		courseRepo.deleteAll();
		
		Course c1=new Course();
		c1.setCourseName("Java");
		
		Course c2=new Course();
		c2.setCourseName("Python");
		
		Course c3=new Course();
		c3.setCourseName("DevOps");
		
		Course c4=new Course();
		c4.setCourseName("Aws");
		
		courseRepo.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		
		statusRepo.deleteAll();
		
		EnquiryStatus s=new EnquiryStatus();
		s.setStatusName("New");
		
		EnquiryStatus s1=new EnquiryStatus();
		s1.setStatusName("Enrolled");
		
		EnquiryStatus s2=new EnquiryStatus();
		s2.setStatusName("Lost");
		
		statusRepo.saveAll(Arrays.asList(s,s1,s2));
		
	}

}
