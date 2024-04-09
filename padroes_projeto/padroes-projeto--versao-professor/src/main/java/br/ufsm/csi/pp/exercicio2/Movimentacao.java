package br.ufsm.csi.pp.exercicio2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movimentacao {

    private TipoMovimentacao tipoMovimentacao;
    private Double valor;
    private String descricao;
    private Date data;

    public enum TipoMovimentacao { CREDITO, DEBITO, RENDIMENTO }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DecimalFormat dm = new DecimalFormat("#,##0.00");
        return sdf.format(data) + "\t" + descricao + "\tR$ " + dm.format(valor) + "\n";
    }

}
