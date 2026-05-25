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

    private String teamHouse;
    private String teamVisitor;
    private String championship;

    private Integer goalHouse = 0;
    private Integer goalVisitor = 0;
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
