package com.springboot.demo.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.springboot.demo.entity.CitizenPlan;
import com.springboot.demo.request.SearchRequest;

public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws IOException;
	
	public boolean exportPdf(HttpServletResponse response) throws IOException;
	

}
