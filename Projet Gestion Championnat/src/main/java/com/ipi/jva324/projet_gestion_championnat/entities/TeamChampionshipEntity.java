package com.ipi.jva324.projet_gestion_championnat.entities;

import jakarta.persistence.*;

@Entity
public class TeamChampionshipEntity {
    @EmbeddedId
    private TeamChampionshipId id;

    @ManyToOne
    @MapsId("idChampionship")
    @JoinColumn(name = "idChampionship")
    private ChampionshipEntity championship;

    @ManyToOne
    @MapsId("idTeam")
    @JoinColumn(name = "idTeam")
    private TeamEntity team;

    // Getters and Setters
    public TeamChampionshipId getId() {
        return id;
    }

    public void setId(TeamChampionshipId id) {
        this.id = id;
    }

    public ChampionshipEntity getChampionship() {
        return championship;
    }

    public void setChampionship(ChampionshipEntity championship) {
        this.championship = championship;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }
}

