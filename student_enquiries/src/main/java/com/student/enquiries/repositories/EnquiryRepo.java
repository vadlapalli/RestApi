package com.student.enquiries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.enquiries.entities.StudentEnquiry;

public interface EnquiryRepo extends JpaRepository<StudentEnquiry, Integer> {

}
