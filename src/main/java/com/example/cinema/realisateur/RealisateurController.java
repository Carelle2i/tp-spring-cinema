package com.example.cinema.realisateur;


import com.example.cinema.film.dto.FilmReduitDto;
import com.example.cinema.realisateur.dto.RealisateurReduitDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;

    private final ObjectMapper objectMapper;

    public RealisateurController(RealisateurService realisateurService,
                          ObjectMapper objectMapper) {
        this.realisateurService = realisateurService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<RealisateurReduitDto> findAll() {
        return realisateurService.findAll().stream().map(
                realisateur -> objectMapper.convertValue(realisateur, RealisateurReduitDto.class)
        ).toList();
    }


    @PostMapping
    public Realisateur save(@RequestBody Realisateur realisateur) {
        return realisateurService.save(realisateur);
    }

    @GetMapping("/{id}")
    public RealisateurReduitDto findById(@PathVariable int id) {
        Realisateur realisateur = realisateurService.findById(id);
        return objectMapper.convertValue(realisateur, RealisateurReduitDto.class);
    }

    @GetMapping("/{id}/films")
    public ResponseEntity<List<FilmReduitDto>> getFilmsByRealisateurId(@PathVariable Long id) {
        List<FilmReduitDto> films = realisateurService.getFilmsByRealisateurId(id);
        return new ResponseEntity<>(films, HttpStatus.OK);
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
