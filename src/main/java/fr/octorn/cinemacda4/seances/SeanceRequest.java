package fr.octorn.cinemacda4.seances;

import java.time.LocalDateTime;

public class SeanceRequest {
        private Integer filmId;
        private Integer salleId;
        private LocalDateTime date;
        private double prix;


    public SeanceRequest(double prix) {
        this.prix = prix;
    }
}


