package io.spring.beans;

public class DebitCardPtm implements IPayment {

	public boolean processPayment(double billAmt) {
		System.out.println("Debit card Payment Proccessed\"");
		return true;
	}

}
