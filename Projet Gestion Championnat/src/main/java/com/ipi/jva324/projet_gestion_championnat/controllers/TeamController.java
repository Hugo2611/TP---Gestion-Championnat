package com.ipi.jva324.projet_gestion_championnat.controllers;

import com.ipi.jva324.projet_gestion_championnat.model.Team;
import com.ipi.jva324.projet_gestion_championnat.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/championship/{championshipId}")
    public ResponseEntity<List<Team>> getTeamsByChampionshipId(@PathVariable Long championshipId) {
        return ResponseEntity.ok(teamService.getTeamsByChampionshipId(championshipId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) {
        Team newTeam = teamService.createTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTeam);
    }

    @PostMapping("/{teamId}/championship/{championshipId}")
    public ResponseEntity<Team> addTeamToChampionship(
            @PathVariable Long teamId,
            @PathVariable Long championshipId) {
        return teamService.addTeamToChampionship(teamId, championshipId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(
            @PathVariable Long id,
            @Valid @RequestBody Team teamDetails) {
        return teamService.updateTeam(id, teamDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        return teamService.deleteTeam(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}