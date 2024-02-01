package com.example.cinema.realisateur;

import com.example.cinema.film.Film;
import com.example.cinema.film.FilmService;
import com.example.cinema.film.dto.FilmReduitDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;
    private final FilmService filmService;
    public RealisateurService(RealisateurRepository realisateurRepository, FilmService filmService) {
        this.realisateurRepository = realisateurRepository;
        this.filmService = filmService;
    }

    public List<FilmReduitDto> getFilmsByRealisateurId(Long realisateurId) {
        return filmService.findAllFilmsByRealisateurId(realisateurId, realisateurId);
    }

    public List<Realisateur> findAll() {

        return realisateurRepository.findAll();
    }

    public Realisateur save(Realisateur realisateur) {

        return realisateurRepository.save(realisateur);
    }

    public Realisateur findById(Integer id) {
        return realisateurRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ce réalisateur n'est pas dans la base de donnée."
                )
        );
    }

    public Realisateur update(Realisateur realisateur) {

        return realisateurRepository.save(realisateur);
    }

    public void deleteById(Integer id) {
        this.findById(id);



        realisateurRepository.deleteById(id);
    }


}
