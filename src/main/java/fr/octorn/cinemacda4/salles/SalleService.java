package fr.octorn.cinemacda4.salles;

import fr.octorn.cinemacda4.salles.exception.SalleNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class SalleService {
        private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository, SalleService salleService) {
            this.salleRepository = salleRepository;
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
    }


