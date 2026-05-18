package com.example.demo.controllers;

import com.example.demo.entities.Player;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*") // Crucial para o seu front mobile em Kotlin não ser bloqueado
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public List<Player> getAll() {
        return service.listarTodos();
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return service.salvar(player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player player) {
        return service.atualizar(id, player);
    }

}
