package io.spring.beans;

public class Car {

	private IEngine eng;

	public Car() {
	}

	public Car(IEngine eng) {
		super();
		this.eng = eng;
	}

	public void setEng(IEngine eng) {
		this.eng = eng;
	}

	public void Drive() {
		int status = eng.start();
		if (status >= 1) {
			System.out.println("Journey Started...");
		} else {
			System.out.println("Engine Failed...");
		}
	}

}
