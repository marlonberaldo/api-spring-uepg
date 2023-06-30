package com.example.uepgApi.repo;

import com.example.uepgApi.model.Jogador;
import com.example.uepgApi.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepo extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByCodJogador(Jogador codJogador);
}
