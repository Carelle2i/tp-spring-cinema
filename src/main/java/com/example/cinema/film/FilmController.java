package com.example.cinema.film;

import com.example.cinema.acteur.dto.ActeurSansFilmDto;
import com.example.cinema.film.dto.FilmCompletDto;
import com.example.cinema.film.dto.FilmReduitDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;
    private final ObjectMapper objectMapper;

    public FilmController(FilmService filmService,
                          ObjectMapper objectMapper) {
        this.filmService = filmService;
        this.objectMapper = objectMapper;
    }


    @GetMapping
    public List<FilmReduitDto> findAll() {
        return filmService.findAll().stream().map(
                film -> objectMapper.convertValue(film, FilmReduitDto.class)
        ).toList();
    }

//    @PostMapping
//    public Film save(@RequestBody Film film) {
//        return filmService.save(film);
//    }

    @PostMapping("/{id}/acteurs")
    public ResponseEntity<FilmCompletDto> addActeurToFilm(
            @PathVariable Long id,
            @RequestBody ActeurSansFilmDto acteurDTO
    ) throws ChangeSetPersister.NotFoundException {
        FilmCompletDto filmDTO = filmService.addActeurToFilm(id, acteurDTO);
        return new ResponseEntity<>(filmDTO, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public FilmCompletDto findById(@PathVariable int id) {
        Film film = filmService.findById(id);
        return objectMapper.convertValue(film, FilmCompletDto.class);
    }

    @PutMapping
    public Film update(@RequestBody Film film) {
        return filmService.update(film);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        filmService.deleteById(id);
    }

    @GetMapping("/search") // /films/search?titre=toto // Le film toto n'est pas dans la bdd :(
    public Film findByTitre(@RequestParam String titre) {
        return filmService.findByTitre(titre);
    }
}
