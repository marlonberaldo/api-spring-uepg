package com.example.uepgApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "pagamento", schema = "")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codPagamento;

    @Column(length = 60, columnDefinition = "SMALLINT")
    private int ano;

    @Column(length = 60, columnDefinition = "SMALLINT")
    private int mes;

    @Column(length = 60, columnDefinition = "NUMERIC")
    private float valor;

    @ManyToOne
    @JoinColumn(name = "codJogador")
    private Jogador codJogador;

    public Pagamento() {
    }

    public Pagamento(int ano, int mes, float valor, Jogador codJogador) {
        this.ano = ano;
        this.mes = mes;
        this.valor = valor;
        this.codJogador = codJogador;
    }

    public long getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(long codPagamento) {
        this.codPagamento = codPagamento;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Jogador getCodJogador() {
        return codJogador;
    }

    public void setCodJogador(Jogador codJogador) {
        this.codJogador = codJogador;
    }

}