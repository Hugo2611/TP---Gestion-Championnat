package com.ipi.jva324.projet_gestion_championnat.service;

import com.ipi.jva324.projet_gestion_championnat.model.Game;
import com.ipi.jva324.projet_gestion_championnat.model.Day;
import com.ipi.jva324.projet_gestion_championnat.model.Team;
import com.ipi.jva324.projet_gestion_championnat.repository.GameRepository;
import com.ipi.jva324.projet_gestion_championnat.repository.DayRepository;
import com.ipi.jva324.projet_gestion_championnat.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final DayRepository dayRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public GameService(GameRepository gameRepository, DayRepository dayRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.dayRepository = dayRepository;
        this.teamRepository = teamRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public List<Game> getGamesByDayId(Long dayId) {
        return gameRepository.findByDayId(dayId);
    }

    public List<Game> getGamesByChampionshipId(Long championshipId) {
        // Supposons que vous avez une méthode pour récupérer les jours par championnat
        List<Day> days = dayRepository.findByChampionshipId(championshipId);
        return gameRepository.findByDayIn(days);
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Optional<Game> createGame(Game game, Long dayId, Long homeTeamId, Long awayTeamId) {
        return dayRepository.findById(dayId)
                .flatMap(day -> teamRepository.findById(homeTeamId)
                        .flatMap(homeTeam -> teamRepository.findById(awayTeamId)
                                .map(awayTeam -> {
                                    game.setDay(day);
                                    game.setHomeTeam(homeTeam);
                                    game.setAwayTeam(awayTeam);
                                    return gameRepository.save(game);
                                })));
    }

    public Optional<Game> updateGame(Long id, Game gameDetails) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setHomeScore(gameDetails.getHomeScore());
                    game.setAwayScore(gameDetails.getAwayScore());
                    game.setHomeTeam(gameDetails.getHomeTeam());
                    game.setAwayTeam(gameDetails.getAwayTeam());
                    game.setDay(gameDetails.getDay());
                    return gameRepository.save(game);
                });
    }

    public boolean deleteGame(Long id) {
        return gameRepository.findById(id)
                .map(game -> {
                    gameRepository.delete(game);
                    return true;
                })
                .orElse(false);
    }
}
