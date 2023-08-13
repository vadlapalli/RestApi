package io.spring;

public class DebitCardPmt implements IPayment {

	@Override
	public boolean proccessPayment(double billAmt) {
		System.out.println("Debit card Payment Proccessed");
		return true;
	}

}
