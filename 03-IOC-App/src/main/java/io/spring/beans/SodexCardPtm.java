package io.spring.beans;

public class SodexCardPtm implements IPayment {

	public boolean processPayment(double billAmt) {
		System.out.println("Sodex card Payment Proccessed\"");
		return true;
	}

}
