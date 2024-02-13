package fr.octorn.cinemacda4.seances;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seances")
public class SeanceController {
    private SeanceService seanceService;

    @PostMapping
    public Seance createSeance(@RequestBody Seance seance) {
        return seanceService.createSeance(seance);
    }
}


