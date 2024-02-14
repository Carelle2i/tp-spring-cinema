package fr.octorn.cinemacda4.seances;


import fr.octorn.cinemacda4.seances.dto.SeanceDto;
import fr.octorn.cinemacda4.tickets.dto.TicketRequest;
import fr.octorn.cinemacda4.tickets.Ticket;
import fr.octorn.cinemacda4.tickets.TicketService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {

    private SeanceService seanceService;
    private TicketService ticketService;

    @PostMapping("/{id}/reserver")
    public ResponseEntity<Ticket> reserveTicketForSeance(
            @PathVariable("id") Long seanceId,
            @RequestBody TicketRequest ticketRequest) {
        Ticket ticket = ticketService.reserveTicket(seanceId, ticketRequest.getNomClient(), ticketRequest.getNbPlaces());
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<List<Ticket>> getReservedTicketsForSeance(@PathVariable Long id) {
        List<Ticket> reservedTickets = ticketService.getReservedTicketsForSeance(id);
        return ResponseEntity.ok(reservedTickets);
    }

    @PostMapping
    public Seance createSeance(@RequestBody Seance seance) {
        return seanceService.createSeance(seance);
    }

    @GetMapping("/{id}/seances")
    public ResponseEntity<List<SeanceDto>> getAvailableSeancesForFilm(
            @PathVariable("id") Long filmId
    ) {
        List<SeanceDto> availableSeances = seanceService.getAvailableSeancesForFilm(filmId);
        return ResponseEntity.ok(availableSeances);
    }
    @GetMapping("/{id}/seances")
    public ResponseEntity<List<Seance>> getAvailableSeancesForFilmAndDate(
            @PathVariable Long id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Seance> availableSeances = seanceService.getAvailableSeancesForFilmAndDate(id, date);
        return ResponseEntity.ok(availableSeances);
    }

}
