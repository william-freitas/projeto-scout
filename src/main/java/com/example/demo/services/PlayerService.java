package com.example.demo.services;

import com.example.demo.entities.Player;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public List<Player> listarTodos() {
        return repository.findAll();
    }

    public Player buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com o ID: " + id));
    }

    public Player salvar(Player player) {
        return repository.save(player);
    }

    public Player atualizar(Integer id, Player playerAtualizado) {
        return repository.findById(id).map(playerExistente -> {
            playerExistente.setName(playerAtualizado.getName());
            playerExistente.setAge(playerAtualizado.getAge());
            playerExistente.setTeam(playerAtualizado.getTeam()); // Nome do time em texto
            playerExistente.setPosition(playerAtualizado.getPosition());
            playerExistente.setGoals(playerAtualizado.getGoals());
            playerExistente.setYellowCard(playerAtualizado.getYellowCard());
            playerExistente.setRedCard(playerAtualizado.getRedCard());
            playerExistente.setAssists(playerAtualizado.getAssists());
            playerExistente.setMatchesPlayed(playerAtualizado.getMatchesPlayed());
            
            // Atualiza o vínculo com a entidade Time se enviado
            if (playerAtualizado.getTeamEntity() != null) {
                playerExistente.setTeamEntity(playerAtualizado.getTeamEntity());
            }
            
            return repository.save(playerExistente);
        }).orElseThrow(() -> new RuntimeException("Jogador não encontrado com o ID: " + id));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
