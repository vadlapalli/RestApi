package io.spring.beans;

public class PaymentService {
	
	private IPayment payment;
	
	public PaymentService() {
	
	}

	public PaymentService(IPayment payment) {
		super();
		this.payment = payment;
	}
	

	public void setPayment(IPayment payment) {
		this.payment = payment;
	}

	public void doPayment(double billAmt) {
		boolean status = payment.processPayment(billAmt);
		
		if(status) {
			System.out.println("Printing Receipt....");
		}else {
			System.out.println("Payment Declined....");
		}
	}

}
