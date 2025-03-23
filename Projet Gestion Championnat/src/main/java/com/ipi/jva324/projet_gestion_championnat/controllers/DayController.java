package com.ipi.jva324.projet_gestion_championnat.controllers;

import com.ipi.jva324.projet_gestion_championnat.model.Day;
import com.ipi.jva324.projet_gestion_championnat.service.DayService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/days")
public class DayController {

    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping
    public ResponseEntity<List<Day>> getAllDays() {
        return ResponseEntity.ok(dayService.getAllDays());
    }

    @GetMapping("/championship/{championshipId}")
    public ResponseEntity<List<Day>> getDaysByChampionshipId(@PathVariable Long championshipId) {
        return ResponseEntity.ok(dayService.getDaysByChampionshipId(championshipId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Day> getDayById(@PathVariable Long id) {
        return dayService.getDayById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/championship/{championshipId}")
    public ResponseEntity<Day> createDay(
            @Valid @RequestBody Day day,
            @PathVariable Long championshipId) {
        return dayService.createDay(day, championshipId)
                .map(newDay -> ResponseEntity.status(HttpStatus.CREATED).body(newDay))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Day> updateDay(
            @PathVariable Long id,
            @Valid @RequestBody Day dayDetails) {
        return dayService.updateDay(id, dayDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDay(@PathVariable Long id) {
        return dayService.deleteDay(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}