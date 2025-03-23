package com.ipi.jva324.projet_gestion_championnat.controllers;

import com.ipi.jva324.projet_gestion_championnat.model.Game;
import com.ipi.jva324.projet_gestion_championnat.service.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/day/{dayId}")
    public ResponseEntity<List<Game>> getGamesByDayId(@PathVariable Long dayId) {
        return ResponseEntity.ok(gameService.getGamesByDayId(dayId));
    }

    @GetMapping("/championship/{championshipId}")
    public ResponseEntity<List<Game>> getGamesByChampionshipId(@PathVariable Long championshipId) {
        return ResponseEntity.ok(gameService.getGamesByChampionshipId(championshipId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        return gameService.getGameById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/day/{dayId}/home/{homeTeamId}/away/{awayTeamId}")
    public ResponseEntity<Game> createGame(
            @Valid @RequestBody Game game,
            @PathVariable Long dayId,
            @PathVariable Long homeTeamId,
            @PathVariable Long awayTeamId) {
        return gameService.createGame(game, dayId, homeTeamId, awayTeamId)
                .map(newGame -> ResponseEntity.status(HttpStatus.CREATED).body(newGame))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(
            @PathVariable Long id,
            @Valid @RequestBody Game gameDetails) {
        return gameService.updateGame(id, gameDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        return gameService.deleteGame(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}