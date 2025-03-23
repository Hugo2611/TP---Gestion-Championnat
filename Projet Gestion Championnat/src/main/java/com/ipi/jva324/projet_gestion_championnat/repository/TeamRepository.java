package com.ipi.jva324.projet_gestion_championnat.repository;

import com.ipi.jva324.projet_gestion_championnat.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT t FROM Team t JOIN t.championships c WHERE c.id = :championshipId")
    List<Team> findAllByChampionshipId(@Param("championshipId") Long championshipId);
    List<Team> findByChampionshipsId(Long championshipId);
}