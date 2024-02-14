package fr.octorn.cinemacda4.salles;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

    @RestController
    @RequestMapping("/salles")
    public class SalleController {
        private final SalleService salleService;

        public SalleController(SalleService salleService, ObjectMapper objectMapper) {
            this.salleService = salleService;
        }

        @GetMapping
        public List<Salle> getAllSalles() {
            return salleService.findAll();
        }

        @GetMapping("/{id}")
        public Salle getSalleById(@PathVariable Long id) {
            return salleService.findById(Math.toIntExact(id));
        }

        @PostMapping
        public Salle createSalle(@RequestBody Salle salle) {
            return salleService.save(salle);
        }

        @PutMapping("/{id}")
        public Salle updateSalle(@PathVariable Long id, @RequestBody Salle salle) {
            return salleService.update(Math.toIntExact(id), salle);
        }
        @GetMapping("/disponible")
        public ResponseEntity<List<Salle>> getAvailableSallesAtDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
            List<Salle> availableSalles = salleService.getAvailableSallesAtDate(date);
            return ResponseEntity.ok(availableSalles);
        }
        @DeleteMapping("/{id}")
        public void deleteById(@PathVariable Integer id) {
            salleService.deleteById(id);
        }
    }


