package com.springboot.demo.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.springboot.demo.entity.CitizenPlan;

@Component
public class ExcelGenerator {

	public void generator(HttpServletResponse response, List<CitizenPlan> records) throws IOException {
		
		// Workbook workbook = new XSSFWorkbook(); for xlxs formate

		try(Workbook workbook = new HSSFWorkbook()){
			
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Names");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Plan Start Date");
		headerRow.createCell(6).setCellValue("Plan End Date");
		headerRow.createCell(7).setCellValue("Benefit Amount");

		int dataRowIndex = 1;
		for (CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getGender());
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			dataRow.createCell(5).setCellValue(plan.getPlanStartDate());
			dataRow.createCell(6).setCellValue(plan.getPlanEndDate());

			if (null != plan.getBenfitAmount()) {
				dataRow.createCell(7).setCellValue(plan.getBenfitAmount());
			} else {
				dataRow.createCell(7).setCellValue("N/A");
			}
			dataRowIndex++;
		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		}
	}
}
