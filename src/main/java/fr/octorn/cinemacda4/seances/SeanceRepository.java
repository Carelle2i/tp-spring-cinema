package fr.octorn.cinemacda4.seances;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SeanceRepository  extends JpaRepository<Seance,Long> {
    long countTicketsBySeanceId(Long seanceId);
}
