package com.ipi.jva324.projet_gestion_championnat.service;

import com.ipi.jva324.projet_gestion_championnat.model.Team;
import com.ipi.jva324.projet_gestion_championnat.model.Championship;
import com.ipi.jva324.projet_gestion_championnat.repository.TeamRepository;
import com.ipi.jva324.projet_gestion_championnat.repository.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final ChampionshipRepository championshipRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, ChampionshipRepository championshipRepository) {
        this.teamRepository = teamRepository;
        this.championshipRepository = championshipRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Optional<Team> addTeamToChampionship(Long teamId, Long championshipId) {
        return teamRepository.findById(teamId)
                .flatMap(team -> championshipRepository.findById(championshipId)
                        .map(championship -> {
                            team.getChampionships().add(championship);
                            return teamRepository.save(team);
                        }));
    }

    public Optional<Team> updateTeam(Long id, Team teamDetails) {
        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(teamDetails.getName());
                    return teamRepository.save(team);
                });
    }

    public boolean deleteTeam(Long id) {
        return teamRepository.findById(id)
                .map(team -> {
                    teamRepository.delete(team);
                    return true;
                })
                .orElse(false);
    }

    public List<Team> getTeamsByChampionshipId(Long championshipId) {
        return teamRepository.findByChampionshipsId(championshipId);
    }
}
