package fr.octorn.cinemacda4.realisateur.dto;

import fr.octorn.cinemacda4.film.Film;
import fr.octorn.cinemacda4.film.dto.FilmMiniDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RealisateurAvecFilmsDto {
    private Integer id;
    private String nom;
    private String prenom;
    private List<FilmMiniDto> films = new ArrayList<>();
}
