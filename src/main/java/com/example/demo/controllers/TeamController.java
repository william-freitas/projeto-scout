package com.example.demo.controllers;

import com.example.demo.entities.Team;
import com.example.demo.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "*") // Permite acesso do front mobile em Kotlin
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public List<Team> getAll() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        return service.salvar(team);
    }

    @PutMapping("/{id}")
    public Team update(@PathVariable Integer id, @RequestBody Team team) {
        return service.atualizar(id, team);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deletar(id);
    }
}
