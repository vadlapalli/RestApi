package io.spring;

public class PaymentService {
	
	private IPayment payment;

	public PaymentService(IPayment payment) {
		super();
		this.payment = payment;
	}
	
	public void doPayment(double billAmt) {
		boolean status = payment.proccessPayment(billAmt);
		
		if(status) {
			System.out.println("Printing Receipt...");
		}else {
			System.out.println("Payment Declined...");
		}
	}

}
