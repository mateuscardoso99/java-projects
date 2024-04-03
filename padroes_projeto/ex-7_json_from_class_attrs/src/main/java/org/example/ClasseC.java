package org.example;

import java.time.LocalDate;

public class ClasseC {
    private String codigo;
    private LocalDate data;
    private ClasseD classeD;
    
    public ClasseC(String codigo, LocalDate data, ClasseD classeD) {
        this.codigo = codigo;
        this.data = data;
        this.classeD = classeD;
    }

    @JSON
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @JSON
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @JSON
    public ClasseD getClasseD() {
        return classeD;
    }

    public void setClasseD(ClasseD classeD) {
        this.classeD = classeD;
    }

    
}

