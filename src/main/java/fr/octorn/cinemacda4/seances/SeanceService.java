package fr.octorn.cinemacda4.seances;


import fr.octorn.cinemacda4.film.FilmService;
import fr.octorn.cinemacda4.salles.SalleRepository;
import fr.octorn.cinemacda4.salles.SalleService;
import fr.octorn.cinemacda4.seances.exception.SeanceValidationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class SeanceService {

    private SeanceRepository seanceRepository;

    private SalleService salleService;

    private FilmService filmService;

    private SalleRepository salleRepository;

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
}




