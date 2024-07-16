package br.ufsm.csi.pp.exercicio6_1;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Memento {

    private String texto;
    private int posicaoCursor;
    private int inicioTextoSelecionado;
    private int fimTextoSelecionado;

}
