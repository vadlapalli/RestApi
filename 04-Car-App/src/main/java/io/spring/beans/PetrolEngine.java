package io.spring.beans;

public class PetrolEngine implements IEngine {

	public int start() {
		System.out.println("Petrol Engine Started");
		return 1;
	}

}
