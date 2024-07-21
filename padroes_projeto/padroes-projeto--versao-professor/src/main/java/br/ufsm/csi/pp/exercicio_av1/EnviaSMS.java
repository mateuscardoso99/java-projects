package br.ufsm.csi.pp.exercicio_av1;

public class EnviaSMS implements Servico {

    public EnviaSMS(int numSMSs) { }
    @Override
    public void executar() {
        System.out.println("[SMS] Enviando SMSs...");
    }
}
