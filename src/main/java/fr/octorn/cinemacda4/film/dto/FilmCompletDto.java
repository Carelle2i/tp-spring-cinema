package fr.octorn.cinemacda4.film.dto;

import fr.octorn.cinemacda4.acteur.dto.ActeurSansFilmDto;
import fr.octorn.cinemacda4.realisateur.Realisateur;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmCompletDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;
    private Realisateur realisateur;
    private List<ActeurSansFilmDto> acteurs = new ArrayList<>();
}
