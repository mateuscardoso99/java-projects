package org.example;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimentacao {

    private TipoMovimentacao tipoMovimentacao;
    private Double valor;
    private String descricao;
    private Date data;

    public Movimentacao(TipoMovimentacao tipoMovimentacao, Double valor, String descricao, Date data) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public enum TipoMovimentacao { CREDITO, DEBITO, RENDIMENTO }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DecimalFormat dm = new DecimalFormat("#,##0.00");
        return sdf.format(data) + "\t" + descricao + "\tR$ " + dm.format(valor) + "\n";
    }

}
