package com.exceptionhandling.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exceptionhandling.controller.DemoControllerr;

@ControllerAdvice
public class AppExceptionHandler {
	
	private Logger logger=LoggerFactory.getLogger(DemoControllerr.class);
	
	//Gobal exception Handling
	
	@ExceptionHandler(Exception.class)
	public String getHandling(Exception e) {
		String msg=e.getMessage();
		logger.error(msg);
		return "errorMsg";
	}

}
