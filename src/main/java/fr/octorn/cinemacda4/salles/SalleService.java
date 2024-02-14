package fr.octorn.cinemacda4.salles;

import fr.octorn.cinemacda4.salles.exception.SalleNotFoundException;
import fr.octorn.cinemacda4.seances.Seance;
import fr.octorn.cinemacda4.seances.SeanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
    public class SalleService {
        private final SalleRepository salleRepository;
        private SeanceRepository seanceRepository;
        private final SalleService salleService;

    public SalleService(SalleRepository salleRepository, SalleService salleService, SalleService salleService1) {
            this.salleRepository = salleRepository;
        this.salleService = salleService1;
    }

        public List<Salle> findAll() {
            return salleRepository.findAll();
        }

        public boolean existsById(Integer id) {
        return salleRepository.existsById(id);
    }
        public Salle findById(Integer id) {
            return salleRepository.findById(id)
                    .orElseThrow(() -> new SalleNotFoundException("Salle non trouvée avec l'ID : " + id));
        }

        public Salle save(Salle salle) {
            return salleRepository.save(salle);
        }

        public Salle update(Integer id, Salle salle) {
            if (!salleRepository.existsById(id)) {
                throw new SalleNotFoundException("Salle non trouvée avec l'ID : " + id);
            }

            salle.setId(Long.valueOf(id));
            return salleRepository.save(salle);
        }

        public void deleteById(Integer id) {
            if (!salleRepository.existsById(id)) {
                throw new SalleNotFoundException("Salle non trouvée avec l'ID : " + id);
            }

            salleRepository.deleteById(id);
        }
    public List<Salle> getAvailableSallesAtDate(LocalDate date) {
        List<Salle> allSalles = salleRepository.findAll();
        List<Seance> seancesAtDate = seanceRepository.findByDate(date);


        List<Salle> availableSalles = allSalles.stream()
                .filter(salle -> seancesAtDate.stream().noneMatch(seance -> seance.getSalle().getId().equals(salle.getId())))
                .collect(Collectors.toList());

        return availableSalles;
    }
    }


