package com.example.cinema.film;

import com.example.cinema.realisateur.Realisateur;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="film")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
    public class Film {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private LocalDate dataSortie;

    @Column(nullable = false)
    private int duree;

    @Column(length = 500)
    private String synopsis;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;
}

