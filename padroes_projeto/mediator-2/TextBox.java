package com.example;

import javax.swing.JTextArea;
import java.awt.event.KeyEvent;

/**
 * Componentes concretos não conversam entre si. Eles têm apenas um canal de comunicação – envio de solicitações ao mediador.
 */
public class TextBox extends JTextArea implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "TextBox";
    }
}
