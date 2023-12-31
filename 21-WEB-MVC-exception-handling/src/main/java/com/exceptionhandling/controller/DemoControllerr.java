package com.exceptionhandling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DemoControllerr {
	
	private Logger logger=LoggerFactory.getLogger(DemoControllerr.class);
	
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		return "index";
	}
	
	@GetMapping("/welcome")
	public String getWwelcomeMsg() {
		int a=10/0;
		return "index";
	}
	
	@GetMapping("/")
	public String getMsg() {
		String s=null;
		s.length();
		return "index";
	}
	
	/*
	 * // LOcal Exception Handling
	 * 
	 * @ExceptionHandler(Exception.class) public String getExceptionMsg(Exception e)
	 * { String msg=e.getMessage(); logger.error(msg); return "errorMsg"; }
	 */
}
