package com.example;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class LoginButton extends JButton implements Component{
    private Mediator mediator;

    public LoginButton() {
        super("Log In");
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        mediator.login();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "LoginButton";
    }    
}
