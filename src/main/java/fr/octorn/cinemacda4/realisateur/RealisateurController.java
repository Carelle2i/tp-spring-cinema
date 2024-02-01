package fr.octorn.cinemacda4.realisateur;

import fr.octorn.cinemacda4.realisateur.dto.RealisateurAvecFilmsDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public List<Realisateur> findAll() {
        return realisateurService.findAll();
    }

    @GetMapping("/{id}")
    public RealisateurAvecFilmsDto findById(@PathVariable int id) {
        return realisateurService.findRealisateurWithFilm(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        realisateurService.deleteById(id);
    }

    @PostMapping
    public Realisateur save(@RequestBody Realisateur realisateur) {
        return realisateurService.save(realisateur);
    }

    @PutMapping
    public Realisateur update(@RequestBody Realisateur realisateur) {
        return realisateurService.save(realisateur);
    }

}
