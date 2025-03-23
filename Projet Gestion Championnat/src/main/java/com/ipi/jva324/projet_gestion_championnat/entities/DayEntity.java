package com.ipi.jva324.projet_gestion_championnat.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @ManyToOne
    @JoinColumn(name = "idChampionship")
    private ChampionshipEntity championship;

    @OneToMany(mappedBy = "day")
    private List<GameEntity> games;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ChampionshipEntity getChampionship() {
        return championship;
    }

    public void setChampionship(ChampionshipEntity championship) {
        this.championship = championship;
    }

    public List<GameEntity> getGames() {
        return games;
    }

    public void setGames(List<GameEntity> games) {
        this.games = games;
    }
}
