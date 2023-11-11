package com.htx.test;

import java.time.LocalDate;

import com.htx.dao.TicketDao;
import com.htx.entities.Ticket;
import com.htx.helper.SFRegistry;

public class HTXTest {
	public static void main(String[] args) {
		try {
			Ticket ticket = new Ticket();
			ticket.setTicketNo(2);
			ticket.setSource("Banglore");
			ticket.setDestination("Jaipur");
			ticket.setPassengerName("Williams");
			ticket.setGender("Male");
			ticket.setAge(24);
			ticket.setJourneyDate(LocalDate.now());
			
			TicketDao ticketDao = new TicketDao();
			ticketDao.saveTicket(ticket);
		}finally {
			SFRegistry.closeSessionFactory();
		}
	}
}
