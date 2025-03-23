package com.ipi.jva324.projet_gestion_championnat.entities;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class ChampionshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du championnat est obligatoire")
    private String name;

    @NotNull(message = "La date de début est obligatoire")
    @PastOrPresent(message = "La date de début doit être aujourd'hui ou dans le passé")
    private Date startDate;

    @NotNull(message = "La date de fin est obligatoire")
    @Future(message = "La date de fin doit être dans le futur")
    private Date endDate;

    @Min(0)
    private int wonPoint;

    @Min(0)
    private int lostPoint;

    @Min(0)
    private int drawPoint;

    @ManyToMany
    @JoinTable(
            name = "TeamChampionshipShip",
            joinColumns = @JoinColumn(name = "idChampionship"),
            inverseJoinColumns = @JoinColumn(name = "idTeam")
    )
    private List<TeamEntity> teams;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getWonPoint() {
        return wonPoint;
    }

    public void setWonPoint(int wonPoint) {
        this.wonPoint = wonPoint;
    }

    public int getLostPoint() {
        return lostPoint;
    }

    public void setLostPoint(int lostPoint) {
        this.lostPoint = lostPoint;
    }

    public int getDrawPoint() {
        return drawPoint;
    }

    public void setDrawPoint(int drawPoint) {
        this.drawPoint = drawPoint;
    }

    public List<TeamEntity> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamEntity> teams) {
        this.teams = teams;
    }
}
