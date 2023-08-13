package io.spring;

public class Test {

	public static void main(String[] args) {
		IPayment p=new CreditCardPmt();
		IPayment p1=new DebitCardPmt();
		PaymentService ps=new PaymentService(p);
		PaymentService ps1=new PaymentService(p1);
		ps.doPayment(450);
		ps1.doPayment(250);
	}

}
