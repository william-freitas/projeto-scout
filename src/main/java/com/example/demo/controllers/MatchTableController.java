package com.example.demo.controllers;

import com.example.demo.entities.MatchTable;
import com.example.demo.services.MatchTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "*") // Essencial para o aplicativo Kotlin conseguir acessar
public class MatchTableController {

    @Autowired
    private MatchTableService service;

    @GetMapping
    public List<MatchTable> getAll() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public MatchTable getById(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public MatchTable create(@RequestBody MatchTable match) {
        return service.salvar(match);
    }

    @PutMapping("/{id}")
    public MatchTable update(@PathVariable Integer id, @RequestBody MatchTable match) {
        return service.atualizar(id, match);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deletar(id);
    }

    @PostMapping("/{id}/compute")
    public String computeMatch(@PathVariable Integer id) {
    service.processarPontosPartida(id);
    return "Pontos dos times atualizados.";
    }

}
