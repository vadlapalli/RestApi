package io.spring;

public class SodexCardPtm implements IPayment {

	@Override
	public boolean proccessPayment(double billAmt) {
		System.out.println("Sodex card Payment Proccessed");
		return false;
	}

}
