package com.example.demo.controllers;

import com.example.demo.entities.Championship;
import com.example.demo.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/championships")
@CrossOrigin(origins = "*") // Permite o acesso do app mobile Kotlin
public class ChampionshipController {

    @Autowired
    private ChampionshipService service;

    @GetMapping
    public List<Championship> getAll() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Championship getById(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Championship create(@RequestBody Championship championship) {
        return service.salvar(championship);
    }

    @PutMapping("/{id}")
    public Championship update(@PathVariable Integer id, @RequestBody Championship championship) {
        return service.atualizar(id, championship);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deletar(id);
    }
}
