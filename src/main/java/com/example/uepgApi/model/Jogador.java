package com.example.uepgApi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity()
@Table(name = "jogador", schema = "myschema")

public class Jogador {

    @Id // Chave Primaria
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codJogador;

    @Column(length = 60, columnDefinition = "VARCHAR")
    private String nome;

    @Column(length = 60, columnDefinition = "VARCHAR")
    private String email;

    @Column(length = 60, columnDefinition = "DATE")
    private Date datanasc;

    public Jogador() {
    }

    public Jogador(String nome, String email, Date datanasc) {
        this.nome = nome;
        this.email = email;
        this.datanasc = datanasc;
    }

    public long getCodJogador() {
        return codJogador;
    }

    public void setCodJogador(long codJogador) {
        this.codJogador = codJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
}