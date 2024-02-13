package fr.octorn.cinemacda4.seances;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.octorn.cinemacda4.film.Film;
import fr.octorn.cinemacda4.salles.Salle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

    public class Seance {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id ;

        @ManyToOne
        @JoinColumn(name = "film_id")
        private Film film;

        @ManyToOne
        @JoinColumn(name = "salle_id")
        private Salle salle;

        private LocalDateTime date;

        private BigDecimal prix;

     // Ajoutez la propriété pour le nombre de places disponibles
         private int placesDisponibles;
}




