package com.example.uepgApi.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.uepgApi.repo.JogadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.uepgApi.model.Jogador;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    JogadorRepo rep;

    // criar jogador
    @PostMapping("/")
    public ResponseEntity<Jogador> criaJogador(@RequestBody Jogador jogador) {
        Jogador novoJogador = rep.save(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogador);
    }

    // listar todos os jogadores
    @GetMapping("/todos")
    public ResponseEntity<List<Jogador>> listaJogadores() {
        List<Jogador> jogadores = rep.findAll();

        // verifica se a lisata de jogadores está vazia
        if (jogadores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jogadores);
    }
}