package com.example.cinema.acteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;

    @Autowired
    public ActeurController(ActeurService acteurService) {
        this.acteurService = acteurService;
    }

    @GetMapping
    public List<Acteur> findAll() {
        return acteurService.findAll();
    }

    @GetMapping("/{id}")
    public Acteur findById(@PathVariable Integer id) {
        return acteurService.findById(id);
    }

    @PostMapping
    public Acteur save(@RequestBody Acteur acteur) {
        return acteurService.save(acteur);
    }

    @PutMapping("/{id}")
    public Acteur update(@PathVariable Integer id, @RequestBody Acteur acteur) {
        acteur.setId(id);
        return acteurService.update(acteur);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        acteurService.deleteById(id);
    }
}
