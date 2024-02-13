package fr.octorn.cinemacda4.tickets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@Validated
public class TicketController {

    private final TicketService ticketService;

    // Injectez le service TicketService par le constructeur

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody @Validated Ticket ticket) {
        // Ajoutez la logique pour vérifier la séance et la disponibilité des places ici
        Ticket createdTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }
}

