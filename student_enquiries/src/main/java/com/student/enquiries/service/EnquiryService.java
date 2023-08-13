package com.student.enquiries.service;


import java.util.List;

import com.student.enquiries.binding.DashboardResponse;
import com.student.enquiries.binding.EnquiryForm;
import com.student.enquiries.binding.EnquirySearchCriteria;
import com.student.enquiries.entities.StudentEnquiry;


public interface EnquiryService {

	public DashboardResponse getDashboardData(Integer userId);
	
	public List<String> getCourses();
	
	public List<String> getEnquiryStatus();
	
	public boolean saveEnquiry(EnquiryForm form);
	
	public List<StudentEnquiry> getEnquiries();
	
	public List<StudentEnquiry> getFilteredEnqs(EnquirySearchCriteria criteria, Integer userId);

}
