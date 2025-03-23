package com.ipi.jva324.projet_gestion_championnat.service;

import com.ipi.jva324.projet_gestion_championnat.model.Championship;
import com.ipi.jva324.projet_gestion_championnat.repository.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChampionshipService {

    private final ChampionshipRepository championshipRepository;

    @Autowired
    public ChampionshipService(ChampionshipRepository championshipRepository) {
        this.championshipRepository = championshipRepository;
    }

    public List<Championship> getAllChampionships() {
        return championshipRepository.findAll();
    }

    public Optional<Championship> getChampionshipById(Long id) {
        return championshipRepository.findById(id);
    }

    public Championship createChampionship(Championship championship) {
        return championshipRepository.save(championship);
    }

    public Optional<Championship> updateChampionship(Long id, Championship championshipDetails) {
        return championshipRepository.findById(id)
                .map(championship -> {
                    championship.setName(championshipDetails.getName());
                    championship.setSeason(championshipDetails.getSeason());
                    // Mettre à jour d'autres propriétés si nécessaire
                    return championshipRepository.save(championship);
                });
    }

    public boolean deleteChampionship(Long id) {
        return championshipRepository.findById(id)
                .map(championship -> {
                    championshipRepository.delete(championship);
                    return true;
                })
                .orElse(false);
    }
}