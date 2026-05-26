package com.example.demo.repositories;

import com.example.demo.entities.MatchTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MatchTableRepository extends JpaRepository<MatchTable, Integer> {

    @Transactional
    @Modifying // Informa ao Spring que esta query vai alterar dados (UPDATE/INSERT) no banco
    @Query(value = "CALL Sp_ComputarPartida(:p_matchID)", nativeQuery = true)
    void computarPartidaNoBanco(@Param("p_matchID") Integer matchId);
}
