package br.ufsm.csi.pp.exercicio5_3;

public class CEO extends Autorizador {


    @Override
    public void autoriza(Reembolso reembolso) {
        System.out.println("CEO aprovou reembolso: " + reembolso);
    }

}
