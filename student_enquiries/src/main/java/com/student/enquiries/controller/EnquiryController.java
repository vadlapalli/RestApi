package com.student.enquiries.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.enquiries.binding.DashboardResponse;
import com.student.enquiries.binding.EnquiryForm;
import com.student.enquiries.binding.EnquirySearchCriteria;
import com.student.enquiries.constant.AppConstants;
import com.student.enquiries.entities.StudentEnquiry;
import com.student.enquiries.repositories.EnquiryRepo;
import com.student.enquiries.service.EnquiryService;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryService enqService;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private EnquiryRepo enquiryRepo;

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}

	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		DashboardResponse dashboardData = enqService.getDashboardData(userId);
		model.addAttribute("dashboardData", dashboardData);
		return "dashboard";
	}

	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {

		initForm(model);
		return AppConstants.STR_ADD_ENQUIRY;
	}

	private void initForm(Model model) {

		// get courses for drop down
		List<String> courses = enqService.getCourses();

		// get enq status for drop down
		List<String> enqStatuses = enqService.getEnquiryStatus();

		// create binding class obj

		EnquiryForm formObj = new EnquiryForm();

		// set data in model obj
		model.addAttribute("formObj", formObj);
		model.addAttribute("courseNames", courses);
		model.addAttribute("statusNames", enqStatuses);

	}

	@PostMapping("/addEnq")
	public String addEnquiry(@ModelAttribute("formObj") EnquiryForm formObj, Model model) {

		boolean status = enqService.saveEnquiry(formObj);

		if (status) {
			model.addAttribute(AppConstants.STR_SUCCESS_MSG, "Enquiry Added");
		} else {
			model.addAttribute(AppConstants.STR_ERROR_MSG, "Problem Occured");
		}
		return AppConstants.STR_ADD_ENQUIRY;

	}

	@GetMapping("/enquiries")
	public String viewEnquiriresPage(Model model) {
		initForm(model);
		model.addAttribute("searchForm", new EnquirySearchCriteria());
		List<StudentEnquiry> enquiries = enqService.getEnquiries();
		model.addAttribute("enquiries", enquiries);
		return "view-enquiries";
	}
	
	@GetMapping("filter-enquiries")
	public String getFilteredEnqs(@RequestParam String cname,@RequestParam String mode,
			@RequestParam String status, Model model) {
		
		EnquirySearchCriteria criteria = new EnquirySearchCriteria();
		criteria.setCourseName(cname);
		criteria.setClassMode(mode);
		criteria.setEnqStatus(status);
		Integer userId = (Integer) session.getAttribute("userId");
		List<StudentEnquiry> filteredEnqs=enqService.getFilteredEnqs(criteria, userId);
		model.addAttribute("enquiries",filteredEnqs);
		return "filter-enquiries-page";
		
	}
	
	@GetMapping("/edit")
	public String editEnquiry(@RequestParam("enqId") Integer enqId,Model model) {
		Optional<StudentEnquiry> findById=enquiryRepo.findById(enqId);
		initForm(model);
		if(findById.isPresent()) {
			StudentEnquiry studentEntity=findById.get();
			model.addAttribute("formObj",studentEntity);
			
		}
		return AppConstants.STR_ADD_ENQUIRY;

	} 
}
