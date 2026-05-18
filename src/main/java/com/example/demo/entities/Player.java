package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String position;
    private String team;
    private Integer goals = 0;
    private Integer assists = 0;
    private Integer matchesPlayed = 0;
    private Integer yellowCards = 0;
    private Integer redCards = 0;
}
