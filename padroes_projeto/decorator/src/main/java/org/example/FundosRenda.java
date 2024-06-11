package org.example;

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


    public TipoFundo getTipo() {
        return tipo;
    }

    public void setTipo(TipoFundo tipo) {
        this.tipo = tipo;
    }

}
