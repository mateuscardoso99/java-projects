package com.example;

public class DiretorOperacoes extends Autorizador{

    public void autoriza(Reembolso reembolso) {
        if(reembolso.getValor() <= 10000){
            System.out.println("DiretorOperacoes aprovou reembolso");
        }
        else{
            getProximoCadeia().autoriza(reembolso);
        }
    }
    
}
