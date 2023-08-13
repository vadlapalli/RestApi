package in.irctcbookingapp.request;

import lombok.Data;

@Data
public class Ticket {
	
	private Integer ticketNum;
	private String name;
	private Double ticketCost;
	private String from;
	private String to;
	private String doj;
	private String status;
	private String trainNumber;
}
