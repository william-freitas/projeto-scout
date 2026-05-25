package com.example.demo.repositories;

import com.example.demo.entities.MatchTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchTableRepository extends JpaRepository<MatchTable, Integer> {
    // CRUD básico estruturado para as partidas
}
