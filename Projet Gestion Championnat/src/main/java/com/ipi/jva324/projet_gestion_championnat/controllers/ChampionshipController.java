package com.ipi.jva324.projet_gestion_championnat.controllers;

import com.ipi.jva324.projet_gestion_championnat.model.Championship;
import com.ipi.jva324.projet_gestion_championnat.service.ChampionshipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/championships")
public class ChampionshipController {

    private final ChampionshipService championshipService;

    @Autowired
    public ChampionshipController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }

    @GetMapping
    public ResponseEntity<List<Championship>> getAllChampionships() {
        return ResponseEntity.ok(championshipService.getAllChampionships());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Championship> getChampionshipById(@PathVariable Long id) {
        return championshipService.getChampionshipById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Championship> createChampionship(@Valid @RequestBody Championship championship) {
        Championship newChampionship = championshipService.createChampionship(championship);
        return ResponseEntity.status(HttpStatus.CREATED).body(newChampionship);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Championship> updateChampionship(
            @PathVariable Long id,
            @Valid @RequestBody Championship championshipDetails) {
        return championshipService.updateChampionship(id, championshipDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChampionship(@PathVariable Long id) {
        return championshipService.deleteChampionship(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
