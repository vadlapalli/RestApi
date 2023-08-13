package io.spring;

public class CreditCardPmt implements IPayment {

	@Override
	public boolean proccessPayment(double billAmt) {
		System.out.println("Credit card Payment Proccessed");
		return true;
	}

}
