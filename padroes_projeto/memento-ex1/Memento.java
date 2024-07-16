package br.ufsm.csi.pp.exercicio6_1;

import lombok.*;

/*

Implementar o padrão memento para o exemplo do Editor apresentado durante a aula. 
• O editor deverá implementar um método onKeyPressed(KeyEvent k) que permite editar o texto contido neste
• Quando o usuário pressionar espaço ou enter deverá ser criado um novo memento, desde que este não contenha o mesmo estado do memento anterior. 
• Caso o usuário pressione Ctrl+z será desfeita a última edição. 
• Caso o usuário pressione Ctrl+r será refeita a última edição desfeita, desde que nenhuma outra edição tenha sido feita neste tempo.

*/

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
