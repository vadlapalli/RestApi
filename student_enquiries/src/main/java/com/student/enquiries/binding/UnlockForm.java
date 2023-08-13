package com.student.enquiries.binding;

import lombok.Data;

@Data
public class UnlockForm {
	
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
	private String email;
		


}
