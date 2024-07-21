package br.ufsm.csi.pp.exercicio5_3;

public class DiretorOperacoes extends Autorizador {


    @Override
    public void autoriza(Reembolso reembolso) {
        if (reembolso.getValor() <= 10000) {
            System.out.println("Diretor de Operacoes aprovou reembolso: " + reembolso);
        } else {
            getProximoCadeia().autoriza(reembolso);
        }
    }

}
