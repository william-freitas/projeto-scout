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

    public Player salvar(Player player) {
        // Regra de negócio simples: garante que novos jogadores não comecem com números negativos
        if (player.getGoals() < 0) player.setGoals(0);
        return repository.save(player);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Player atualizar(Long id, Player playerAtualizado) {
    // Busca o jogador atual no banco. Se não achar, lança um erro.
    return repository.findById(id).map(playerExistente -> {
        // Atualiza apenas os campos permitidos
        playerExistente.setName(playerAtualizado.getName());
        playerExistente.setPosition(playerAtualizado.getPosition());
        playerExistente.setTeam(playerAtualizado.getTeam());
        playerExistente.setGoals(playerAtualizado.getGoals());
        playerExistente.setAssists(playerAtualizado.getAssists());
        playerExistente.setMatchesPlayed(playerAtualizado.getMatchesPlayed());
        
        // Salva o jogador com os dados novos
        return repository.save(playerExistente);
    }).orElseThrow(() -> new RuntimeException("Jogador não encontrado com o ID: " + id));
}

}

