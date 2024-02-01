package fr.octorn.cinemacda4.film.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
public class FilmMiniDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
}
