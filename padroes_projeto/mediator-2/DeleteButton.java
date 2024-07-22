package com.example;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

/**
 * Componentes concretos não conversam entre si. Eles têm apenas um canal de comunicação – envio de solicitações ao mediador.
 */
public class DeleteButton extends JButton implements Component {
    private Mediator mediator;

    public DeleteButton() {
        super("Del");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.deleteNote();
    }

    @Override
    public String getName() {
        return "DelButton";
    }
}
