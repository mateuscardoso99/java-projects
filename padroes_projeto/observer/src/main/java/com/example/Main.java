package com.example;

/**
 * OBSERVER
 * 
 * O padrão Observer é útil para projetar um modelo de comunicação consistente entre um conjunto de 
 * objetos dependentes e um objeto do qual eles dependem. 
 * Isso permite que os objetos dependentes tenham seu estado sincronizado com o objeto de que eles dependem. 
 * 
 * O conjunto de objetos dependentes é referido como observadores e o objeto de que eles dependem é referido como o sujeito
 * Para fazer isso, o padrão Observer sugere um modelo de assinante de publicador (publisher-subscriber);
 * 
 * Assim, qualquer objeto com interesse no estado do sujeito precisa se registrar explicitamente como observador com o sujeito. 
 * Sempre que o sujeito sofre uma alteração no seu estado, notifica todos os seus observadores registados. 
 * Assim, um indivíduo se comporta como um publicador, publicando mensagens para todos os seus observadores assinantes
 * 
 * um exemplo seria notificar um cliente quando um novo item chegasse na loja, os clientes que tiverem interesse nesse tipo de evento
 * se inscrevem (subscribe) para receber notificações de quando o sujeito
 */
public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        loja.getService().subscribe(Evento.NOVO_ITEM, new EmailMsgOuvinte("joao@gmail.com")); //inscrevendo um cliente para ser notificado quando chegar um novo item
        loja.getService().subscribe(Evento.OFERTA, new EmailMsgOuvinte("maria@gmail.com")); //inscrevendo um cliente para ser notificado quando chegar uma nova oferta
        loja.getService().subscribe(Evento.NOVO_ITEM,  new AppMobileOuvinte("carlos silva")); //inscrevendo um cliente para ser notificado quando chegar um novo item
        
        loja.notificarNovoItem(); //chegou um novo item e vai notificar os clientes que estão inscritos para receber notificações de novo item, essas notificações serão por email ou no app
        loja.notificarNovaOferta();

        loja.getService().unsubscribe(Evento.OFERTA, new EmailMsgOuvinte("maria@gmail.com")); //desinscrevendo um cliente para não mais ser notificado quando chegar um novo item
        loja.notificarNovaOferta();
    }
}