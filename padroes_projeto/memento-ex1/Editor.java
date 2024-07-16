package br.ufsm.csi.pp.exercicio6_1;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

/*
O estado de um objeto pode ser definido como os valores de suas
propriedades ou atributos em qualquer ponto do tempo. – O Padrão Memento é útil para projetar um mecanismo para capturar e
armazenar o estado de um objeto para que, posteriormente, quando
necessário, o objeto pode ser colocado de volta a este estado (anterior). 

Pode ser usado para implementar uma função desfazer, sem expor a estrutura interna do objeto. 
– O objeto cujo estado precisa ser capturado é referido como o originador. 
• Quando um cliente deseja salvar o estado do originador, ele solicita o estado atual do originador. 
• O originador armazena todos os atributos que são necessários para restaurar seu estado em um objeto separado, referenciado como uma lembrança e retorna para o cliente. 
• Assim, um Memento pode ser visto como um objeto que contém o estado interno de outro objeto, em um determinado ponto do tempo. 
• Quando o cliente deseja restaurar, ele simplesmente passa o Memento de volta para o originador. O originador restaura o estado armazenado no objeto Memento.
*/

public class Editor {

    private JEditorPane jEditorPane = new JEditorPane();
    private Stack<Memento> pilhaUndo = new Stack<>();
    private Stack<Memento> pilhaRedo = new Stack<>();

    public Editor() {
        jEditorPane.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Memento memento = produzMemento();
                    if (pilhaUndo.empty() || !pilhaUndo.peek().equals(memento)) {
                        pilhaUndo.push(memento);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_Z &&
                        (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)
                {
                    if (!pilhaUndo.empty()) {
                        Memento memento = pilhaUndo.pop();
                        Memento estadoAtual = produzMemento();
                        pilhaRedo.push(estadoAtual);
                        restabeleceEstado(memento);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_R &&
                        (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0) {
                    if (!pilhaRedo.empty()) {
                        Memento memento = pilhaRedo.pop();
                        restabeleceEstado(memento);
                    }
                } else {
                    pilhaRedo.clear();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private Memento produzMemento() {
        return new Memento(jEditorPane.getText(),
                jEditorPane.getCaretPosition(),
                jEditorPane.getSelectionStart(),
                jEditorPane.getSelectionEnd());
    }

    private void restabeleceEstado(Memento memento) {
        if (memento == null) return;
        jEditorPane.setText(memento.getTexto());
        jEditorPane.setCaretPosition(memento.getPosicaoCursor());
        jEditorPane.setSelectionStart(memento.getInicioTextoSelecionado());
        jEditorPane.setSelectionEnd(memento.getFimTextoSelecionado());
    }

}
