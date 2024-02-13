package fr.octorn.cinemacda4.salles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalleRepository extends JpaRepository<Salle, Integer> {

    @Query("SELECT s.capacite FROM Salle s WHERE s.id = :salleId")
    Integer findCapaciteById(@Param("salleId") Integer salleId);
}




