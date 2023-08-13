package com.student.enquiries.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="AIT_COURSES")
public class Course {
	
	@Id
	@GeneratedValue
	private Integer courseId;
	private String courseName;

}
