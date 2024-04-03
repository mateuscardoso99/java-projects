package org.example;

public class ClasseB {
    private int id;
    private String descricao;
    private ClasseC classeC;

    public ClasseB(int id, String descricao, ClasseC classeC) {
        this.id = id;
        this.descricao = descricao;
        this.classeC = classeC;
    }
    
    @JSON
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @JSON
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JSON
    public ClasseC getClasseC() {
        return classeC;
    }

    public void setClasseC(ClasseC classeC) {
        this.classeC = classeC;
    }

    
}

