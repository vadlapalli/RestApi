package com.student.enquiries.binding;

import lombok.Data;

@Data
public class EnquiryForm {
	
	private Integer enqId;
	private String studentName;
	private Long studentPhno;
	private String studentEmail;
	private String classMode;
	private String courseName;
	private String enqStatus;

}
