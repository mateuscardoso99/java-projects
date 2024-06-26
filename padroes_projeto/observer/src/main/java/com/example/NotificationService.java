package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//PUBLISHER, responsável por publicar as notificações aos seus ouvintes
public class NotificationService {
    private final Map<Evento, List<Ouvinte>> ouvintes; 
    //guarda uma lista com os ouvintes ouvintes para cada tipo de evento (EmailMsgOuvinte ou AppMobileOuvinte), mas é uma list de Ouvinte ou seja, está referenciando pela interface, então qualquer coisa que implementar ouvinte vai funcionar

    public NotificationService() {
        ouvintes = new HashMap<>();
        Arrays.stream(Evento.values()).forEach(event -> ouvintes.put(event, new ArrayList<>()));
    }

    public void subscribe(Evento eventType, Ouvinte ouvinte) {
        ouvintes.get(eventType).add(ouvinte);
    }

    public void unsubscribe(Evento eventType, Ouvinte ouvinte) {
        ouvintes.get(eventType).remove(ouvinte);
    }

    public void notifyOuvintes(Evento eventType) {
        ouvintes.get(eventType).forEach(ouvinte -> ouvinte.update(eventType)); 
        //chama o método update de cada ouvinte (EmailMsgOuvinte ou AppMobileOuvinte)
    }
}
