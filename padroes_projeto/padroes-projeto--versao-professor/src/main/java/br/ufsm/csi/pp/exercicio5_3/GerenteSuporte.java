package br.ufsm.csi.pp.exercicio5_3;

public class GerenteSuporte extends Autorizador {


    @Override
    public void autoriza(Reembolso reembolso) {
        if (reembolso.getValor() <= 1000) {
            System.out.println("Gerente de Suporte aprovou reembolso: " + reembolso);
        } else {
            getProximoCadeia().autoriza(reembolso);
        }
    }

}
