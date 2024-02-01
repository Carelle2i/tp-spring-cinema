package com.example.cinema.film.dto;


import com.example.cinema.acteur.dto.ActeurSansFilmDto;
import com.example.cinema.realisateur.dto.RealisateurAvecFilmDto;
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

    private RealisateurAvecFilmDto realisateur;

    private List<ActeurSansFilmDto> acteurs = new ArrayList<>();

    private RealisateurAvecFilmDto realisateurs;
}