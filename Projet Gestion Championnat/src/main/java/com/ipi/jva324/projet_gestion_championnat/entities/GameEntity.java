package com.ipi.jva324.projet_gestion_championnat.entities;

import jakarta.persistence.*;

@Entity
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int team1Point;
    private int team2Point;

    @ManyToOne
    @JoinColumn(name = "idTeam1")
    private TeamEntity team1;

    @ManyToOne
    @JoinColumn(name = "idTeam2")
    private TeamEntity team2;

    @ManyToOne
    @JoinColumn(name = "idDay")
    private DayEntity day;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTeam1Point() {
        return team1Point;
    }

    public void setTeam1Point(int team1Point) {
        this.team1Point = team1Point;
    }

    public int getTeam2Point() {
        return team2Point;
    }

    public void setTeam2Point(int team2Point) {
        this.team2Point = team2Point;
    }

    public TeamEntity getTeam1() {
        return team1;
    }

    public void setTeam1(TeamEntity team1) {
        this.team1 = team1;
    }

    public TeamEntity getTeam2() {
        return team2;
    }

    public void setTeam2(TeamEntity team2) {
        this.team2 = team2;
    }

    public DayEntity getDay() {
        return day;
    }

    public void setDay(DayEntity day) {
        this.day = day;
    }
}
