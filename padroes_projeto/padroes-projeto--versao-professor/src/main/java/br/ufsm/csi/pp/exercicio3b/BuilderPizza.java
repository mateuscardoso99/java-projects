package br.ufsm.csi.pp.exercicio3b;

public class BuilderPizza implements Builder {
    @Override
    public void fazMassa() {
        System.out.println("[builder] massa pizza");
    }

    @Override
    public void colocaMolhoVermelho() {
        System.out.println("[builder] molho vermelho pizza");
    }

    @Override
    public void colocaQueijoMussarela() {
        System.out.println("[builder] queijo mussarela pizza");
    }

    @Override
    public void colocaQueijoParmesao() {
        System.out.println("[builder] queijo parmesao pizza");
    }

    @Override
    public void colocaQueijoCheddar() {
        System.out.println("[builder] queijo cheddar pizza");
    }

    @Override
    public void fazBordaRecheada() {
        System.out.println("[builder] borda recheada pizza");
    }

    @Override
    public void colocaCalabreza() {
        System.out.println("[builder] calabreza pizza");
    }

    @Override
    public void colocarFile() {
        System.out.println("[buider] file pizza");
    }

    @Override
    public void colocaCebola() {
        System.out.println("[builder] cebola pizza");
    }
}
