package br.ufsm.csi.pp.exercicio3b;

public class BuilderCalzone implements Builder {
    @Override
    public void fazMassa() {
        System.out.println("[builder] massa calzone");
    }

    @Override
    public void colocaMolhoVermelho() {
        System.out.println("[builder] molho vermelho calzone");
    }

    @Override
    public void colocaQueijoMussarela() {
        System.out.println("[builder] queijo mussarela calzone");
    }

    @Override
    public void colocaQueijoParmesao() {
        System.out.println("[builder] queijo parmesao calzone");
    }

    @Override
    public void colocaQueijoCheddar() {
        System.out.println("[builder] queijo cheddar calzone");
    }

    @Override
    public void fazBordaRecheada() {
        System.out.println("[builder] borda recheada calzone");
    }

    @Override
    public void colocaCalabreza() {
        System.out.println("[builder] calabreza calzone");
    }

    @Override
    public void colocarFile() {
        System.out.println("[buider] file calzone");
    }

    @Override
    public void colocaCebola() {
        System.out.println("[builder] cebola calzone");
    }
}
