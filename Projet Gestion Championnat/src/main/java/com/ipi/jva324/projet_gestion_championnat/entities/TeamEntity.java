package com.ipi.jva324.projet_gestion_championnat.entities;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date creationDate;

    @ManyToMany(mappedBy = "teams")
    private List<ChampionshipEntity> championships;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<ChampionshipEntity> getChampionships() {
        return championships;
    }

    public void setChampionships(List<ChampionshipEntity> championships) {
        this.championships = championships;
    }
}
