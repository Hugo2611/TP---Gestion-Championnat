package com.ipi.jva324.projet_gestion_championnat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;

    @Min(value = 0, message = "Le score ne peut pas être négatif")
    private Integer homeScore;

    @Min(value = 0, message = "Le score ne peut pas être négatif")
    private Integer awayScore;

    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    @JsonIgnore
    private Day day;

    // Constructeurs
    public Game() {
    }

    public Game(Team homeTeam, Team awayTeam, Day day) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.day = day;
    }

    public Game(Team homeTeam, Team awayTeam, Integer homeScore, Integer awayScore, Day day) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.day = day;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", homeTeam=" + homeTeam.getName() +
                ", awayTeam=" + awayTeam.getName() +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                '}';
    }
}