package org.example;

public class ClasseD {
    private Long id;
    private String situacao;
    
    public ClasseD(Long id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    @JSON
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JSON
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
}

