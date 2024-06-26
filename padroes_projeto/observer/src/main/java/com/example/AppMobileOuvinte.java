package com.example;

//SUBSCRIBER (assinante)
public class AppMobileOuvinte implements Ouvinte{
    private String username;

    public AppMobileOuvinte(String username){
        this.username = username;
    }
    
    @Override
    public void update(Evento eventType) {
        System.out.println("enviando notificação para app para "+username);
    }
    
}
