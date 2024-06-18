package br.ufsm.csi.pp.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FundosRenda extends ContaBancaria implements Cloneable {

    private TipoFundo tipo;

    private FundosRenda() { }

    public static FundosRenda newInstance() {
        return new FundosRenda();
    }

    @Override
    public Double calculaIR() {
        if (getMovimentacoes() == null) return 0.0;
        Double ir = 0.0;
        for (Movimentacao movimentacao : getMovimentacoes()) {
            if (movimentacao.getTipoMovimentacao() == Movimentacao.TipoMovimentacao.RENDIMENTO) {
                ir += movimentacao.getValor() * 0.275;
            }
        }
        return ir;
    }


    public enum TipoFundo {
        RENDA_FIXA, RENDA_VARIAVEL
    }

}
