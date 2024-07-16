package com.example;

public class SuporteTecnico extends Autorizador{

    @Override
    public void autoriza(Reembolso reembolso) {
        if(reembolso.getValor() <= 100){
            System.out.println("suporte tecnico aprovou reembolso");
        }
        else{
            getProximoCadeia().autoriza(reembolso);
        }
    }
    
}
