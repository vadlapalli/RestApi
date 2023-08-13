package com.student.enquiries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.enquiries.entities.EnquiryStatus;

public interface StatusRepo extends JpaRepository<EnquiryStatus, Integer> {

}
