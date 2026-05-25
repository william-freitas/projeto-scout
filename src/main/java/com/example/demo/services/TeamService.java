package com.example.demo.services;

import com.example.demo.entities.Team;
import com.example.demo.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public List<Team> listarTodos() {
        return repository.findAll();
    }

    public Team buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time não encontrado com o ID: " + id));
    }

    public Team salvar(Team team) {
        return repository.save(team);
    }

    public Team atualizar(Integer id, Team teamAtualizado) {
        return repository.findById(id).map(teamExistente -> {
            teamExistente.setName(teamAtualizado.getName());
            teamExistente.setPoints(teamAtualizado.getPoints());
            teamExistente.setMatchesPlayed(teamAtualizado.getMatchesPlayed());
            teamExistente.setClassification(teamAtualizado.getClassification());
            
            // Atualiza o campeonato caso tenha sido alterado
            if (teamAtualizado.getChampionship() != null) {
                teamExistente.setChampionship(teamAtualizado.getChampionship());
            }
            
            return repository.save(teamExistente);
        }).orElseThrow(() -> new RuntimeException("Time não encontrado com o ID: " + id));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
