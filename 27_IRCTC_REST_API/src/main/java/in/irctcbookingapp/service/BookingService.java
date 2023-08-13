package in.irctcbookingapp.service;

import in.irctcbookingapp.request.Passenger;
import in.irctcbookingapp.request.Ticket;

public interface BookingService {
	
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNum);

}
