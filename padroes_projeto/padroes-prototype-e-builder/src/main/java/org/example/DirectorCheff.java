package org.example;

public class DirectorCheff {
    private Builder builder;

    public DirectorCheff(Builder builder){
        this.builder = builder;
    }

    public void maguerita(){
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.colocaMussarela();
        builder.fazBordaRecheada();
    }

    public void calabresa(){
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.colocaMussarela();
        builder.colocaCalabresa();
    }

    public void portuguesa(){
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.colocaMussarela();
        builder.colocaCalabresa();
        builder.colocaCebola();
    }

    public void tresQueijos(){
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.colocaMussarela();
        builder.colocaQueijoChedar();
        builder.fazBordaRecheada();
    }

    public void daCasa(){
        builder.fazMassa();
        builder.colocaFile();
        builder.colocaQueijoParmesao();
        builder.colocaCebola();
        builder.fazBordaRecheada();
    }
}
