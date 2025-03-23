package com.ipi.jva324.projet_gestion_championnat.repository;

import com.ipi.jva324.projet_gestion_championnat.model.Day;
import com.ipi.jva324.projet_gestion_championnat.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByDayId(Long dayId);

    List<Game> findByHomeTeamIdOrAwayTeamId(Long teamId, Long teamId1);

    List<Game> findByDayIn(List<Day> days);
}
