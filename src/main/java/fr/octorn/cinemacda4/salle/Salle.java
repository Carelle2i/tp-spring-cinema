package fr.octorn.cinemacda4.salle;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salle_id")
    private Long id;
    private String nom;
    private int capacite;
}
