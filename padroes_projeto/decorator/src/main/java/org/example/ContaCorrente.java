package org.example;

import java.util.Date;

public class ContaCorrente extends ContaBancaria implements Cloneable {

    private boolean especial;
    private Double limite;

    private ContaCorrente() {}

    public static ContaCorrente newInstance() {
        return new ContaCorrente();
    }

    public void saque(Double valor) {
        if (valor <= getSaldo() || (especial && valor <= (getSaldo() + limite))) {
            setSaldo(getSaldo() - valor);
            Movimentacao movimentacao = new Movimentacao(Movimentacao.TipoMovimentacao.DEBITO, valor, "SAQUE NA BOCA DO CAIXA", new Date());
            getMovimentacoes().add(movimentacao);

        }
    }

    @Override
    public Double calculaIR() {
        return 0.0;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    
}
