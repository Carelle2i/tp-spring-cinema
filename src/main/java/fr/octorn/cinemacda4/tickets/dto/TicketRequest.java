package fr.octorn.cinemacda4.tickets.dto;

import lombok.Data;

@Data
public class TicketRequest {
    private Long seanceId;
    private String nomClient;
    private int nbPlaces;

}
