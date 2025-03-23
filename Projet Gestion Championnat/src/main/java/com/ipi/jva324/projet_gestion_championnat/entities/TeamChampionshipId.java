package com.ipi.jva324.projet_gestion_championnat.entities;


import java.io.Serializable;
import jakarta.persistence.*;


@Embeddable
public class TeamChampionshipId implements Serializable {
    @Column(name = "idChampionship")
    private Long idChampionship;

    @Column(name = "idTeam")
    private Long idTeam;

    // Getters and Setters
    public Long getIdChampionship() {
        return idChampionship;
    }

    public void setIdChampionship(Long idChampionship) {
        this.idChampionship = idChampionship;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }
}
