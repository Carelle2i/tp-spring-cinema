package fr.octorn.cinemacda4.seances;

import fr.octorn.cinemacda4.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface SeanceRepository  extends JpaRepository<Seance,Long> {
    long countTicketsBySeanceId(Long seanceId);
    List<Seance> findByDate(LocalDate date);
    List<Seance> findByFilmAndDateAfterAndPlacesDisponiblesGreaterThan(Film film, LocalDateTime date, int places);
    List<Seance> findByFilmIdAndDateBetweenAndPlacesDisponiblesGreaterThan(
            Long filmId, LocalDateTime startDate, LocalDateTime endDate, Integer placesDisponibles);
}
