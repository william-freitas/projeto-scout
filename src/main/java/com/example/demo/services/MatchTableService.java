package com.example.demo.services;

import com.example.demo.entities.MatchTable;
import com.example.demo.repositories.MatchTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchTableService {

    @Autowired
    private MatchTableRepository repository;

    public List<MatchTable> listarTodas() {
        return repository.findAll();
    }

    public MatchTable buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partida não encontrada com o ID: " + id));
    }

    public MatchTable salvar(MatchTable match) {
        return repository.save(match);
    }

    public MatchTable atualizar(Integer id, MatchTable matchAtualizada) {
        return repository.findById(id).map(matchExistente -> {
            matchExistente.setTeamHouse(matchAtualizada.getTeamHouse());
            matchExistente.setTeamVisitor(matchAtualizada.getTeamVisitor());
            matchExistente.setChampionship(matchAtualizada.getChampionship());
            matchExistente.setGoalHouse(matchAtualizada.getGoalHouse());
            matchExistente.setGoalVisitor(matchAtualizada.getGoalVisitor());
            matchExistente.setMatchDate(matchAtualizada.getMatchDate());
            
            // Atualiza os relacionamentos (FKs) caso tenham mudado
            if (matchAtualizada.getTeamHouseEntity() != null) {
                matchExistente.setTeamHouseEntity(matchAtualizada.getTeamHouseEntity());
            }
            if (matchAtualizada.getTeamVisitorEntity() != null) {
                matchExistente.setTeamVisitorEntity(matchAtualizada.getTeamVisitorEntity());
            }
            if (matchAtualizada.getChampionshipEntity() != null) {
                matchExistente.setChampionshipEntity(matchAtualizada.getChampionshipEntity());
            }
            
            return repository.save(matchExistente);
        }).orElseThrow(() -> new RuntimeException("Partida não encontrada com o ID: " + id));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
