package fr.octorn.cinemacda4.seances.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SeanceDto {
    private Long id;
    private BigDecimal prix;
    private LocalDateTime date;
    private Integer placesDisponibles;

    public SeanceDto(Long id, BigDecimal prix, LocalDateTime date, int placesDisponibles) {
    }

    // Constructor, getters, and setters...
}

