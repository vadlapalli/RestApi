package com.student.enquiries.binding;

import lombok.Data;

@Data
public class DashboardResponse {
	
	private Integer totEnquiriesCnt;
	private Integer enrolledEnquiriesCnt;
	private Integer lostEnquiriesCnt;

}
