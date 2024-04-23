package org.example;

public class BuilderCalzone implements Builder{

    @Override
    public void fazMassa() {
        System.out.println("[builder] massa calzone");
    }

    @Override
    public void colocaMolhoVermelho() {
        System.out.println("[builder] molho veremelho calzone");
    }

    @Override
    public void colocaMussarela() {
        System.out.println("[builder] mussarela calzone");
    }

    @Override
    public void colocaQueijoParmesao() {
        System.out.println("[builder] queijo parmesão calzone");
    }

    @Override
    public void colocaQueijoChedar() {
        System.out.println("[builder] queijo cheddar calzone");
    }

    @Override
    public void fazBordaRecheada() {
        System.out.println("[builder] borda recheada calzone");
    }

    @Override
    public void colocaCalabresa() {
        System.out.println("[builder] calabresa calzone");
    }

    @Override
    public void colocaFile() {
        System.out.println("[builder] file calzone");
    }

    @Override
    public void colocaCebola() {
        System.out.println("[builder] cebola calzone");
    }
    
}
