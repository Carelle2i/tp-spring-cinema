package com.example.cinema.realisateur.dto;


import com.example.cinema.acteur.dto.ActeurSansFilmDto;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class RealisateurDto {
    private Long id;
    private String nom;
    private String prenom;

    private List<ActeurSansFilmDto> acteurs = new ArrayList<>();
}
