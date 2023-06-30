package com.example.uepgApi.repo;

import com.example.uepgApi.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadorRepo extends JpaRepository<Jogador, Long> {

    List<Jogador> findByCodJogador(long codJogador);

}
