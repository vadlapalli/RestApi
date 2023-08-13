package com.student.enquiries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.enquiries.entities.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}