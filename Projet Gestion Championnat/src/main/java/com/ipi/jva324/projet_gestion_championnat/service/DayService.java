package com.ipi.jva324.projet_gestion_championnat.service;

import com.ipi.jva324.projet_gestion_championnat.model.Day;
import com.ipi.jva324.projet_gestion_championnat.model.Championship;
import com.ipi.jva324.projet_gestion_championnat.repository.DayRepository;
import com.ipi.jva324.projet_gestion_championnat.repository.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DayService {

    private final DayRepository dayRepository;
    private final ChampionshipRepository championshipRepository;

    @Autowired
    public DayService(DayRepository dayRepository, ChampionshipRepository championshipRepository) {
        this.dayRepository = dayRepository;
        this.championshipRepository = championshipRepository;
    }

    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }

    public Optional<Day> getDayById(Long id) {
        return dayRepository.findById(id);
    }

    public Optional<Day> createDay(Day day, Long championshipId) {
        return championshipRepository.findById(championshipId)
                .map(championship -> {
                    day.setChampionship(championship);
                    return dayRepository.save(day);
                });
    }

    public Optional<Day> updateDay(Long id, Day dayDetails) {
        return dayRepository.findById(id)
                .map(day -> {
                    day.setChampionship(dayDetails.getChampionship());
                    day.setName(dayDetails.getName());
                    day.setDate(dayDetails.getDate());
                    return dayRepository.save(day);
                });
    }

    public boolean deleteDay(Long id) {
        return dayRepository.findById(id)
                .map(day -> {
                    dayRepository.delete(day);
                    return true;
                })
                .orElse(false);
    }

    public List<Day> getDaysByChampionshipId(Long championshipId) {
        return dayRepository.findByChampionshipId(championshipId);
    }
}
