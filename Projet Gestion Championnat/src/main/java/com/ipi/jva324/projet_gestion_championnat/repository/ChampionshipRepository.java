package com.ipi.jva324.projet_gestion_championnat.repository;

import com.ipi.jva324.projet_gestion_championnat.model.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Long> {
}