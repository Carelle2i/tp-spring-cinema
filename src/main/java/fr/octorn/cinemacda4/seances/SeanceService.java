package fr.octorn.cinemacda4.seances;


import fr.octorn.cinemacda4.film.Film;
import fr.octorn.cinemacda4.film.FilmRepository;
import fr.octorn.cinemacda4.film.FilmService;
import fr.octorn.cinemacda4.film.exceptions.FilmNotFoundException;
import fr.octorn.cinemacda4.salles.SalleRepository;
import fr.octorn.cinemacda4.salles.SalleService;
import fr.octorn.cinemacda4.seances.dto.SeanceDto;
import fr.octorn.cinemacda4.seances.exception.SeanceNotFoundException;
import fr.octorn.cinemacda4.seances.exception.SeanceValidationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeanceService {
    private final SeanceService seanceService;
    private final SeanceRepository seanceRepository;

    private SalleService salleService;
    private SalleRepository salleRepository;
    private FilmService filmService;
    private FilmRepository filmRepository;


    public SeanceService(SeanceService seanceService, SeanceRepository seanceRepository) {
        this.seanceService = seanceService;
        this.seanceRepository = seanceRepository;
    }

    public Seance getSeanceById(Long seanceId) {
        return seanceRepository.findById(seanceId)
                .orElseThrow(() -> new SeanceNotFoundException("Seance not found with id: " + seanceId));
    }
    public Seance createSeance(Seance seance) {
        // Vérifie que la salle et le film existent bien
        if (!salleService.existsById(Math.toIntExact(seance.getSalle().getId())) || !filmService.existsById(seance.getFilm().getId())) {
            throw new SeanceValidationException("La salle ou le film n'existe pas.");
        }

        // Vérifie que la date est dans le futur
        LocalDateTime now = LocalDateTime.now();
        if (seance.getDate().isBefore(now)) {
            throw new SeanceValidationException("La date de la séance est passé.");
        }

        // Vérifie que le prix est positif
        if (seance.getPrix().compareTo(BigDecimal.ZERO) <= 0) {
            throw new SeanceValidationException("Le prix doit être supérieur à 0.");
        }

        // Capacité de la salle
        Integer capacite = salleRepository.findCapaciteById(Math.toIntExact(seance.getSalle().getId()));

        // Calcule le nombre de places disponibles
        seance.setPlacesDisponibles((int) (capacite - seanceRepository.countTicketsBySeanceId(seance.getId())));

        // Enregistre la séance
        return seanceRepository.save(seance);
    }
    public void updateAvailablePlaces(Seance seance, int nbReservedPlaces) {
        int availablePlaces = seance.getPlacesDisponibles() - nbReservedPlaces;
        seance.setPlacesDisponibles(availablePlaces);
        seanceRepository.save(seance);
    }
    public List<Seance> getSeancesByDate(LocalDate date) {
        return seanceRepository.findByDate(date);
    }
    public List<SeanceDto> getAvailableSeancesForFilm(Long filmId) {
        Film film = filmRepository.findById(Math.toIntExact(filmId))
                .orElseThrow(() -> new FilmNotFoundException(Math.toIntExact(filmId)));

        LocalDateTime now = LocalDateTime.now();

        List<Seance> availableSeances = seanceRepository.findByFilmAndDateAfterAndPlacesDisponiblesGreaterThan(film, now, 0);

        return availableSeances.stream()
                .map(this::mapToSeanceDto)
                .collect(Collectors.toList());
    }

    private SeanceDto mapToSeanceDto(Seance seance) {
        return new SeanceDto(seance.getId(), seance.getPrix(), seance.getDate(), seance.getPlacesDisponibles());
    }
    public List<Seance> getAvailableSeancesForFilmAndDate(Long filmId, LocalDate date) {

        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return seanceRepository.findByFilmIdAndDateBetweenAndPlacesDisponiblesGreaterThan(filmId, startOfDay, endOfDay, 0);
    }
}





