package org.example.classes;

public enum TipoUso {
    COMERCIAL("comercial"),
    RESIDENCIAL("residencial");

    public final String label;

    private TipoUso(String label){
        this.label = label;
    }
}
