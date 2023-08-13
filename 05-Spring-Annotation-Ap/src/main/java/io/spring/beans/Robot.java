package io.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	@Autowired
	private Chip chip;
	
	
	public Robot() {
		System.out.println("Robot :: Constructor");
	}
	
	public void doWork() {
		String type = chip.chipType();
		
		if(type.equals("32-bit")) {
			System.out.println("Performance is slow..");	
		}
	}

}
