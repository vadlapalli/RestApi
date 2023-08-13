package io.spring.beans;

public class DieselEngine implements IEngine {

	public int start() {
		System.out.println("Diesel Engine Started");
		return 1;
	}

}
