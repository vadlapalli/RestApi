package io.spring;

public class App {

	public static void main(String[] args) {
		Car c=new Car(new DeiselEngine());
		c.setEng(new PetrolEngine());
		c.drive();

	}

}
