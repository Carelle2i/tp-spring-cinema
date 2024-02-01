package com.example.cinema.film.films;


import com.example.cinema.acteur.dto.ActeurSansFilmDto;
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

    private RealisateurDto realisateur;

    private List<ActeurSansFilmDto> acteurs = new ArrayList<>();
}