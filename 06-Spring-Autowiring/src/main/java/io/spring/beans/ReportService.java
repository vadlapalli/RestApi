package io.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	
	@Autowired
	@Qualifier("oracledb")
	private ReportDao dao;
	
	public void generateData() {
		dao.getdata();
		System.out.println("Report generated...");
	}

}
	