package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Championship")
@Data
public class Championship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "champID")
    private Integer champId;

    @Column(nullable = false, length = 100)
    private String name;

    private Integer matchQuantity;
}
