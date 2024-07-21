package br.ufsm.csi.pp.exercicio_av1;

public class EnviaEmail implements Servico {
    @Override
    public void executar() {
        System.out.println("[EMAIL] Enviando emails...");
    }
}
