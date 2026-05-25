package com.example.demo.services;

import com.example.demo.entities.Championship;
import com.example.demo.repositories.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChampionshipService {

    @Autowired
    private ChampionshipRepository repository;

    public List<Championship> listarTodos() {
        return repository.findAll();
    }

    public Championship buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campeonato não encontrado com o ID: " + id));
    }

    public Championship salvar(Championship championship) {
        return repository.save(championship);
    }

    public Championship atualizar(Integer id, Championship chAtualizado) {
        return repository.findById(id).map(chExistente -> {
            chExistente.setName(chAtualizado.getName());
            chExistente.setMatchQuantity(chAtualizado.getMatchQuantity());
            return repository.save(chExistente);
        }).orElseThrow(() -> new RuntimeException("Campeonato não encontrado com o ID: " + id));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
