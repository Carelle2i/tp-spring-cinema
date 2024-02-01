package fr.octorn.cinemacda4.film;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.octorn.cinemacda4.acteur.Acteur;
import fr.octorn.cinemacda4.acteur.dto.ActeurReduitDto;
import fr.octorn.cinemacda4.acteur.dto.ActeurSansFilmDto;
import fr.octorn.cinemacda4.film.dto.FilmCompletDto;
import fr.octorn.cinemacda4.film.dto.FilmReduitDto;
import fr.octorn.cinemacda4.realisateur.Realisateur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;

    private final ObjectMapper objectMapper;

    public FilmController(
            FilmService filmService,
            ObjectMapper objectMapper
    ) {
        this.filmService = filmService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<FilmReduitDto> findAll() {
        return filmService.findAll().stream().map(
                film -> objectMapper.convertValue(film, FilmReduitDto.class)
        ).toList();
    }

    @PostMapping
    public Film save(@RequestBody Film film) {
        return filmService.save(film);
    }

    @GetMapping("/{id}") // /films/1
    public FilmCompletDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);

        FilmCompletDto filmCompletDto = new FilmCompletDto();
        filmCompletDto.setId(film.getId());
        filmCompletDto.setDuree(film.getDuree());
        filmCompletDto.setSynopsis(film.getSynopsis());
        filmCompletDto.setRealisateur(film.getRealisateur());
        filmCompletDto.setDateSortie(film.getDateSortie());
        filmCompletDto.setActeurs(
                film.getActeurs().stream().map(
                        acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
                ).toList()
        );


        return filmCompletDto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        filmService.deleteById(id);
    }

    @PutMapping
    public Film update(@RequestBody Film film) {
        return filmService.update(film);
    }

    @GetMapping("/search") // /film/search?titre=toto
    public Film findByTitre(@RequestParam String titre) {
        return filmService.findByTitre(titre);
    }

    @GetMapping("/{id}/acteurs")
    public List<ActeurSansFilmDto> findActeursByFilm(@PathVariable Integer id) {
        List<Acteur> acteurs = filmService.findActeursByFilm(id);

        return acteurs.stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
        ).toList();
    }

    @GetMapping("/{id}/realisateurs")
    public Realisateur findRealisateursByFilm(@PathVariable Integer id) {
        return filmService.findById(id).getRealisateur();
    }
}
