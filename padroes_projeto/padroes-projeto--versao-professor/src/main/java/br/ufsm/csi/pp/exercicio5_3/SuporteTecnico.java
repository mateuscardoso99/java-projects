package br.ufsm.csi.pp.exercicio5_3;

public class SuporteTecnico extends Autorizador {

    @Override
    public void autoriza(Reembolso reembolso) {
        if (reembolso.getValor() <= 100) {
            System.out.println("Suporte Tecnico aprovou reembolso: " + reembolso);
        } else {
            getProximoCadeia().autoriza(reembolso);
        }
    }

}
