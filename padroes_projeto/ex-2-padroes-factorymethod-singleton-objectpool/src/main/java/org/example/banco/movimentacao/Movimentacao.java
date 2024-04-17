package org.example.banco.movimentacao;

public class Movimentacao {
    private String descricao;
    private Double valor;
    private TipoMovimentacao tipoMovimentacao;

    public java.lang.String getDescricao() {
        return descricao;
    }

    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }

    public java.lang.Double getValor() {
        return valor;
    }

    public void setValor(java.lang.Double valor) {
        this.valor = valor;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Movimentacao that = (Movimentacao) object;

        if (!java.util.Objects.equals(descricao, that.descricao)) return false;
        if (!java.util.Objects.equals(valor, that.valor)) return false;
        return tipoMovimentacao == that.tipoMovimentacao;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (tipoMovimentacao != null ? tipoMovimentacao.hashCode() : 0);
        return result;
    }
}
