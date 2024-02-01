package com.example.cinema.acteur;

import com.example.cinema.acteur.dto.ActeurReduitDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;
    private final ObjectMapper objectMapper;

    public ActeurController(ActeurService acteurService, ObjectMapper objectMapper) {
        this.acteurService = acteurService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/id")
    public List<ActeurReduitDto> findAll() {
        return acteurService.findAll().stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurReduitDto.class)
        ).toList();
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