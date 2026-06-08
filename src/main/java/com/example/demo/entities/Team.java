package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Team")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamID")
    private Integer teamId;

    @Column(nullable = false, length = 100)
    private String name;

    private Integer points = 0;
    @Column(name = "matchesPlayed")
    private Integer matchesPlayed = 0;
    private Integer classification;

    @ManyToOne
    @JoinColumn(name = "champId", referencedColumnName = "champID") // Nome exato da FK do seu script
    private Championship championship;
}
