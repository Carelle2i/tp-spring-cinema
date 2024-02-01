package fr.octorn.cinemacda4.film.dto;

import fr.octorn.cinemacda4.realisateur.Realisateur;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmSansActeurDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private Realisateur realisateur;
}
