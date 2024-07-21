package br.ufsm.csi.pp.exercicio5_3;

public class TesteMain {

    public static void main(String[] args) {
        CEO ceo = new CEO();
        DiretorOperacoes diretor = new DiretorOperacoes();
        GerenteSuporte gerente = new GerenteSuporte();
        SuporteTecnico suporteTecnico = new SuporteTecnico();
        suporteTecnico.setProximoCadeia(gerente);
        gerente.setProximoCadeia(diretor);
        diretor.setProximoCadeia(ceo);
        Reembolso reembolso = new Reembolso("fone da nasa", 15000.0);
        suporteTecnico.autoriza(reembolso);
    }

}
