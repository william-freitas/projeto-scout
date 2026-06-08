package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Player")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerID")
    private Integer playerId;

    @Column(nullable = false, length = 100)
    private String name;

    private Integer age;
    private String team; // Mantido o campo de texto do seu script
    private String position;
    private Integer goals = 0;
    @Column(name = "yellowCard")
    private Integer yellowCard = 0;
    @Column(name = "redCard")
    private Integer redCard = 0;
    private Integer assists = 0;
    @Column(name = "matchesPlayed")
    private Integer matchesPlayed = 0;

    @ManyToOne
    @JoinColumn(name = "teamId") // Nome exato da FK do seu script
    private Team teamEntity; 
}
