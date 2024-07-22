package com.example;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

/**
 * Componentes concretos não conversam entre si. Eles têm apenas um canal de comunicação – envio de solicitações ao mediador.
 */
public class AddButton extends JButton implements Component {
    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.addNewNote(new Note());
    }

    @Override
    public String getName() {
        return "AddButton";
    }
}