package fr.octorn.cinemacda4.acteur.dto;

import fr.octorn.cinemacda4.film.dto.FilmSansActeurDto;
import lombok.Data;

import java.util.List;

@Data
public class ActeurReduitDto {
    private Integer id;
    private String nom;
    private String prenom;
    private List<FilmSansActeurDto> films;
}
