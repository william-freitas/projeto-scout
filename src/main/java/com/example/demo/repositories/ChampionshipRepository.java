package com.example.demo.repositories;

import com.example.demo.entities.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {
    // CRUD básico (salvar, listar, buscar por id e deletar) já injetado aqui
}
