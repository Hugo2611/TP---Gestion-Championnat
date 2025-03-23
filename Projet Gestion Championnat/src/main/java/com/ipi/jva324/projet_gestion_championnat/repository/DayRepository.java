package com.ipi.jva324.projet_gestion_championnat.repository;

import com.ipi.jva324.projet_gestion_championnat.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
    List<Day> findByChampionshipId(Long championshipId);
}