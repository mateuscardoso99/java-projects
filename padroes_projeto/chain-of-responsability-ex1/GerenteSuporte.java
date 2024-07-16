package com.example;

public class GerenteSuporte extends Autorizador{

    public void autoriza(Reembolso reembolso) {
        if(reembolso.getValor() <= 1000){
            System.out.println("GerenteSuporte aprovou reembolso");
        }
        else{
            getProximoCadeia().autoriza(reembolso);
        }
    }
    
}
