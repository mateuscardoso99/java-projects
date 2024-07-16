package com.example;

public class Main {
    public static void main(String[] args) {
        CEO ceo = new CEO();
        DiretorOperacoes diretorOperacoes = new DiretorOperacoes();
        GerenteSuporte gerenteSuporte = new GerenteSuporte();
        SuporteTecnico suporteTecnico = new SuporteTecnico();

        suporteTecnico.setProximoCadeia(gerenteSuporte);
        gerenteSuporte.setProximoCadeia(diretorOperacoes);
        diretorOperacoes.setProximoCadeia(ceo);
        ceo.setProximoCadeia(null);
        
        Reembolso reembolso = new Reembolso();
        reembolso.setDescricao("compra");
        reembolso.setValor(1200d);

        suporteTecnico.autoriza(reembolso);
    }
}