package fr.octorn.cinemacda4.salle;

import fr.octorn.cinemacda4.salle.exception.SalleNotAvailableException;
import lombok.Data;

import java.util.List;

@Data
public class SalleService {
    private final SalleRepository salleRepository;

    private final SalleService salleService;

    public SalleService(SalleRepository salleRepository, SalleService salleService) {
        this.salleRepository = salleRepository;
        this.salleService = salleService;
    }

    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    public Salle findById(Integer id) {
        return salleRepository.findById(id)
                .orElseThrow(() -> new SalleNotAvailableException("Salle non trouvée avec l'ID : " + id));
    }

    public Salle save(Salle salle) {
        return salleRepository.save(salle);
    }

    public Salle update(Integer id, Salle salle) {
        if (!salleRepository.existsById(id)) {
            throw new SalleNotAvailableException("Salle non trouvée avec l'ID : " + id);
        }

        salle.setId(Long.valueOf(id));
        return salleRepository.save(salle);
    }

    public void deleteById(Integer id) {
        if (!salleRepository.existsById(id)) {
            throw new SalleNotAvailableException("Salle non trouvée avec l'ID : " + id);
        }

        salleRepository.deleteById(id);
    }
}
