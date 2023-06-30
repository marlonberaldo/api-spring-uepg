package com.example.uepgApi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.uepgApi.repo.JogadorRepo;
import com.example.uepgApi.repo.PagamentoRepo;
import com.example.uepgApi.model.Jogador;
import com.example.uepgApi.model.Pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")

public class PagamentoController {

    @Autowired
    PagamentoRepo rep;

    @Autowired
    JogadorRepo jogadorRep;

    // cria pagamento de jogador
    @PostMapping("/")
    public ResponseEntity<Pagamento> criaPagamento(@RequestBody Map<String, Object> requestBody) {
        long codJogador = Long.parseLong(requestBody.get("codJogador").toString());
        int ano = Integer.parseInt(requestBody.get("ano").toString());
        int mes = Integer.parseInt(requestBody.get("mes").toString());
        double valor = Double.parseDouble(requestBody.get("valor").toString());

        List<Jogador> jogadores = jogadorRep.findByCodJogador(codJogador);

        if (jogadores.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Jogador jogador = jogadores.get(0);
        Pagamento pagamento = rep.save(new Pagamento(ano, mes, (float) valor, jogador));

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    // listar pagamentos
    @GetMapping("/")
    public ResponseEntity<List<Pagamento>> listaPagamento() {
        List<Pagamento> pagamentos = rep.findAll();

        if (pagamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pagamentos);
    }

    // listar pagamentos jogador especifico
    @GetMapping("/{codJogador}")
    @ResponseBody
    public ResponseEntity<List<Pagamento>> pegaPagamento(@PathVariable("codJogador") long codJogador) {
        List<Jogador> jogadores = jogadorRep.findByCodJogador(codJogador);

        if (jogadores.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Jogador jogador = jogadores.get(0);
        List<Pagamento> pagamentos = rep.findByCodJogador(jogador);

        if (pagamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(pagamentos);
    }
}