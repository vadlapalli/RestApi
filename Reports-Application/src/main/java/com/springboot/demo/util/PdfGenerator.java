package com.springboot.demo.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springboot.demo.entity.CitizenPlan;

@Component
public class PdfGenerator {

	public void generator(HttpServletResponse response, List<CitizenPlan> plans) throws IOException {

		try (Document document = new Document(PageSize.A4)) {
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

			Paragraph p = new Paragraph("Citizen Plan Info");
			document.add(p);

			PdfPTable table = new PdfPTable(7);
			table.setSpacingBefore(5);

			table.addCell("Id");
			table.addCell("Citizen Name");
			table.addCell("Gender");
			table.addCell("Plan Names");
			table.addCell("Plan Status");
			table.addCell("Plan Start Date");
			table.addCell("Plan End Date");

			for (CitizenPlan plan : plans) {
				table.addCell(String.valueOf(plan.getCitizenId()));
				table.addCell(plan.getCitizenName());
				table.addCell(plan.getGender());
				table.addCell(plan.getPlanName());
				table.addCell(plan.getPlanStatus());
				table.addCell(plan.getPlanStartDate() + " ");
				table.addCell(plan.getPlanEndDate() + " ");

			}
			document.add(table);
		}

	}

}
