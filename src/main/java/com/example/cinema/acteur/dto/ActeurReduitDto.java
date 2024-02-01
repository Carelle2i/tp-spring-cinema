package com.example.cinema.acteur.dto;

import lombok.Data;

import java.util.List;

@Data
public class ActeurReduitDto {
    private List<ActeurSansFilmDto> acteurs;

}
