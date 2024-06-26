package com.example;

public class Loja {
    private final NotificationService notificationService;

    public Loja() {
        notificationService = new NotificationService();
    }

    public void notificarNovoItem() {
        notificationService.notifyOuvintes(Evento.NOVO_ITEM);
    }

    public void notificarNovaOferta() {
        notificationService.notifyOuvintes(Evento.OFERTA);
    }

    public NotificationService getService() {
        return notificationService;
    }
}
