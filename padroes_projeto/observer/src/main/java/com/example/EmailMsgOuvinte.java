package com.example;

//SUBSCRIBER (assinante)
public class EmailMsgOuvinte implements Ouvinte{
    private String email;

    public EmailMsgOuvinte(String email){
        this.email = email;
    }

    @Override
    public void update(Evento eventType) {
        System.out.println("enviando email para " + email);
    }
    
}
