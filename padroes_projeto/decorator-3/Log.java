package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private  TipoEntrada tipoEntrada;
    private Long idObjetoAlterado;
    private String classeObjetoAlterado;

    public enum TipoEntrada{

        CRIAÇÃO, REMOÇÃO, ATUALIZAÇÃO, LEITURA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public Long getIdObjetoAlterado() {
        return idObjetoAlterado;
    }

    public void setIdObjetoAlterado(Long idObjetoAlterado) {
        this.idObjetoAlterado = idObjetoAlterado;
    }

    public String getClasseObjetoAlterado() {
        return classeObjetoAlterado;
    }

    public void setClasseObjetoAlterado(String classeObjetoAlterado) {
        this.classeObjetoAlterado = classeObjetoAlterado;
    }
}
