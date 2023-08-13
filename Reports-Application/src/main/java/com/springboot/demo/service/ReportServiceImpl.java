package com.springboot.demo.service;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springboot.demo.entity.CitizenPlan;
import com.springboot.demo.repository.CitizenPlanRepository;
import com.springboot.demo.request.SearchRequest;
import com.springboot.demo.util.EmailUtils;
import com.springboot.demo.util.ExcelGenerator;
import com.springboot.demo.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private CitizenPlanRepository planRepo;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(localDate);
		}

		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws IOException {
		List<CitizenPlan> plans = planRepo.findAll();
		excelGenerator.generator(response, plans);
		String subject = "Test mail subject";
		String body="<h1>Test mail body</h1>";
		String to="harivadlapalli1997@gmail.com";
		
		emailUtils.sendEmail(subject, body, to);
		
		return true;
	}	

	@Override
	public boolean exportPdf(HttpServletResponse response) throws IOException {
		List<CitizenPlan> plans = planRepo.findAll();
		pdfGenerator.generator(response, plans);
		return true;
	}

	

}
