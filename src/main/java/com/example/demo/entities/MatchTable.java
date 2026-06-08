package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Match_Table")
@Data
public class MatchTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchID")
    private Integer matchId;

    @Column(name = "teamHouse")
    private String teamHouse;
    @Column(name = "teamVisitor")
    private String teamVisitor;
    private String championship;

    @Column(name = "goalHouse")
    private Integer goalHouse = 0;
    @Column(name = "goalVisitor")
    private Integer goalVisitor = 0;
    @Column(name = "matchDate")
    private LocalDate matchDate;

    @ManyToOne
    @JoinColumn(name = "teamHouseID")
    private Team teamHouseEntity;

    @ManyToOne
    @JoinColumn(name = "teamVisitorID")
    private Team teamVisitorEntity;

    @ManyToOne
    @JoinColumn(name = "champID")
    private Championship championshipEntity;
}
