package io.spring.beans;

public class CreditCardPtm implements IPayment {

	public boolean processPayment(double billAmt) {
		System.out.println("Credit card Payment Proccessed");
		return true;
	}

}
