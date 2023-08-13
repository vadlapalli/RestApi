package com.springboot.demo.util;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String subject,String body,String to) {
		
		Logger logger=LoggerFactory.getLogger(EmailUtils.class);
		
		try {
			
			MimeMessage mimeMsg = mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMsg);
			helper.setSubject(subject);
			helper.setText(body,true);
			helper.setTo(to);
			mailSender.send(mimeMsg);
			}catch(Exception e) {
			logger.error(e.getMessage());
		}
		
		return true;
	}
	
}
