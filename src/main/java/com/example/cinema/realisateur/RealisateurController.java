package com.example.cinema.realisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;

    @Autowired
    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public List<Realisateur> findAll() {
        return realisateurService.findAll();
    }

    @GetMapping("/{id}")
    public Realisateur findById(@PathVariable Integer id) {
        return realisateurService.findById(id);
    }

    @PostMapping
    public Realisateur save(@RequestBody Realisateur realisateur) {
        return realisateurService.save(realisateur);
    }

    @PutMapping("/{id}")
    public Realisateur update(@PathVariable Integer id, @RequestBody Realisateur realisateur) {
        realisateur.setId(id);
        return realisateurService.update(realisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        realisateurService.deleteById(id);
    }
}
