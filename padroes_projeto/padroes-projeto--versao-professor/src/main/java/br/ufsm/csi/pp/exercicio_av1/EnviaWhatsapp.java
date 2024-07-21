package br.ufsm.csi.pp.exercicio_av1;

public class EnviaWhatsapp implements Servico {
    @Override
    public void executar() {
        System.out.println("[WPP] Enviando whatsapp...");
    }
}
