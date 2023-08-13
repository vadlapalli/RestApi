package com.student.enquiries.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="AIT_ENQUIRY_STATUS")
public class EnquiryStatus {
	
	@Id
	@GeneratedValue
	private Integer enqstatusId;
	private String statusName;
	

}
