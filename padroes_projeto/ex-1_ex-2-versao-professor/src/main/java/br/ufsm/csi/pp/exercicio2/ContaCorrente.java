package br.ufsm.csi.pp.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContaCorrente extends ContaBancaria {

    private boolean especial;
    private Double limite;

    public boolean saque(Double valor) {
        if (valor <= getSaldo() || (especial && valor <= (getSaldo() + limite))) {
            setSaldo(getSaldo() - valor);
            Movimentacao movimentacao = new Movimentacao(Movimentacao.TipoMovimentacao.DEBITO, valor, "SAQUE NA BOCA DO CAIXA", new Date());
            getMovimentacoes().add(movimentacao);
            return true;
        }
        return false;
    }

    @Override
    public Double calculaIR() {
        return 0.0;
    }
}
