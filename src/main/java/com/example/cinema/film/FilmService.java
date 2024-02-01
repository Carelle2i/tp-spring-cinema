package com.example.cinema.film;

import com.example.cinema.acteur.dto.ActeurSansFilmDto;
import com.example.cinema.film.dto.FilmCompletDto;
import com.example.cinema.film.dto.FilmReduitDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {
    private final FilmRepository filmRepository;



    public FilmCompletDto addActeurToFilm(Long filmId, ActeurSansFilmDto acteurSansFilmDto) throws ChangeSetPersister.NotFoundException {
        Film film = filmRepository.findById(Math.toIntExact(filmId))
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        filmRepository.save(film);

        return convertToFilmCompletDTO(film);
    }

    private FilmCompletDto convertToFilmCompletDTO(Film film) {
        // Conversion de l'entité Film en DTO FilmCompletDTO
        return null;
    }

    private FilmReduitDto convertToFilmRealisateurDTO(Film film) {
        FilmReduitDto filmDTO = new FilmReduitDto();
        filmDTO.setTitre(film.getTitre());
        filmDTO.setDateSortie(film.getDateSortie());
        return filmDTO;
    }

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }
//    public Film save(FilmReduitDto film) {
//        return filmRepository.save(film);
//    }
    public Film findById(Integer id) {
        return filmRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Ce film n'est pas dans la base de donnée :("
                )
        );
    }
    public Film update(Film film) {

        return filmRepository.save(film);
    }
    public void deleteById(Integer id) {
        Film film = this.findById(id);
        filmRepository.delete(film);
    }
    public Film findByTitre(String titre) {
        return filmRepository.findByTitre(titre).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trouvé")
        );
    }

    public List<FilmReduitDto> findAllFilmsByRealisateurId(Long realisateurId, Object id) {

        return null;
    }

    public void save(FilmReduitDto film) {
    }
}


