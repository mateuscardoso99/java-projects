package br.ufsm.csi.pp.exercicio6_1;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

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
