package fr.octorn.cinemacda4.tickets;

import fr.octorn.cinemacda4.seances.Seance;
import fr.octorn.cinemacda4.seances.SeanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private TicketService ticketService;
    private TicketRepository ticketRepository;

    private SeanceService seanceService;
    public Ticket createTicket(Ticket ticket) {

        return ticketRepository.save(ticket);
    }

    public Ticket reserveTicket(Long seanceId, String nomClient, int nbPlaces) {
        Seance seance = seanceService.getSeanceById(seanceId);



        Ticket ticket = new Ticket();
        ticket.setSeance(seance);
        ticket.setNomClient(nomClient);
        ticket.setNbPlaces(nbPlaces);


        Ticket savedTicket = ticketRepository.save(ticket);


        seanceService.updateAvailablePlaces(seance, nbPlaces);

        return savedTicket;
    }
    public List<Ticket> getReservedTicketsForSeance(Long seanceId) {
        return ticketRepository.findBySeanceId(seanceId);
    }
}

