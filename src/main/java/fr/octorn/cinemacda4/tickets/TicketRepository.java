package fr.octorn.cinemacda4.tickets;

// TicketRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}

