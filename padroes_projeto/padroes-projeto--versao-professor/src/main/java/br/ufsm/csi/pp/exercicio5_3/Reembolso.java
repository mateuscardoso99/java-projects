package br.ufsm.csi.pp.exercicio5_3;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Reembolso {

    private String descricao;
    private Double valor;

}
