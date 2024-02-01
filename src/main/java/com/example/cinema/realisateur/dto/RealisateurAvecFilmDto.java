package com.example.cinema.realisateur.dto;


import com.example.cinema.film.dto.FilmReduitDto;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class RealisateurAvecFilmDto {
    private Long id;
    private String nom;
    private String prenom;

    private List<FilmReduitDto> film = new ArrayList<>();
}
