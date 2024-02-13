package fr.octorn.cinemacda4.tickets;

import org.springframework.stereotype.Service;

@Service
public interface TicketService {
    Ticket createTicket(Ticket ticket);
}
