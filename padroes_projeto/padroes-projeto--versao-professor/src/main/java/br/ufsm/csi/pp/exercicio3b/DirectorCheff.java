package br.ufsm.csi.pp.exercicio3b;

public class DirectorCheff {

    private Builder builder;

    public DirectorCheff(Builder builder) {
        this.builder = builder;
    }

    public void maguerita() {
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.colocaQueijoMussarela();
        builder.fazBordaRecheada();
    }

    public void calabeza() {
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.colocaQueijoMussarela();
        builder.colocaCalabreza();
    }

    public void portuguesa() {
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.colocaQueijoMussarela();
        builder.colocaCalabreza();
        builder.colocaCebola();
    }

    public void tresQueijos() {
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.colocaQueijoMussarela();
        builder.colocaQueijoCheddar();
        builder.colocaQueijoParmesao();
        builder.fazBordaRecheada();
    }

    public void daCasa() {
        builder.fazMassa();
        builder.colocaMolhoVermelho();
        builder.fazBordaRecheada();
        builder.colocaQueijoMussarela();
        builder.colocaCebola();
        builder.colocaQueijoParmesao();
        builder.colocaQueijoCheddar();
        builder.colocaCalabreza();
        builder.colocarFile();
    }

}
