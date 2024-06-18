package br.ufsm.csi.pp.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class ContaCorrente extends ContaBancaria implements Cloneable {

    private boolean especial;
    private Double limite;

    private ContaCorrente() {}

    public static ContaCorrente newInstance() {
        return new ContaCorrente();
    }

    public void saque(Double valor) throws MovimentacaoException {
        if (valor <= getSaldo() || (especial && valor <= (getSaldo() + limite))) {
            setSaldo(getSaldo() - valor);
            Movimentacao movimentacao = new Movimentacao(Movimentacao.TipoMovimentacao.DEBITO, valor, "SAQUE NA BOCA DO CAIXA", new Date());
            getMovimentacoes().add(movimentacao);

        }
        throw new MovimentacaoException("saldo insuficiente");
    }

    @Override
    public Double calculaIR() {
        return 0.0;
    }
}
