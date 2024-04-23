package org.example;

public class BuilderPizza implements Builder{

    @Override
    public void fazMassa() {
        System.out.println("[builder] massa pizza");
    }

    @Override
    public void colocaMolhoVermelho() {
        System.out.println("[builder] molho veremelho pizza");
    }

    @Override
    public void colocaMussarela() {
        System.out.println("[builder] mussarela pizza");
    }

    @Override
    public void colocaQueijoParmesao() {
        System.out.println("[builder] queijo parmesão pizza");
    }

    @Override
    public void colocaQueijoChedar() {
        System.out.println("[builder] queijo cheddar pizza");
    }

    @Override
    public void fazBordaRecheada() {
        System.out.println("[builder] borda recheada pizza");
    }

    @Override
    public void colocaCalabresa() {
        System.out.println("[builder] calabresa pizza");
    }

    @Override
    public void colocaFile() {
        System.out.println("[builder] file pizza");
    }

    @Override
    public void colocaCebola() {
        System.out.println("[builder] cebola pizza");
    }
    
}
