package com.example.trab_bancodados2_hibernate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 50)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restaurante")
    private Set<Cardapio> cardapios = new HashSet<>();

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RestauranteRefeicao> refeicoes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Cardapio> getCardapios() {
        return cardapios;
    }

    public void setCardapios(Set<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }

    public Set<RestauranteRefeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(Set<RestauranteRefeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }    

    @Override
    public String toString() {
        return "Restaurante [id=" + id 
                + ", nome=" + nome 
                + ", cardapios=" + cardapios.stream().map(Cardapio::getDescricao).collect(Collectors.toList())
                + ", refeicoes=" + refeicoes.stream().map(RestauranteRefeicao::getRefeicao).map(Refeicao::getDescricao).collect(Collectors.toList())
            + "]";
    }


    
}
