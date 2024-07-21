package com.example;

import java.io.File;

/*
 * O Facade é um padrão de projeto estrutural que fornece uma interface simplificada (mas limitada) para um sistema 
 * complexo de classes, biblioteca, ou framework.
 * 
 * Embora o Facade diminua a complexidade geral do aplicativo, também ajuda a mover dependências indesejadas para um só local.
 * O padrão Facade é comumente usado em aplicações escritas em Java. É especialmente útil ao trabalhar com bibliotecas e APIs complexas.
 * 
 * 
 * Aqui estão alguns exemplos do Facade nas principais bibliotecas Java:
 * javax.faces.context.FacesContext usa LifeCycle, ViewHandler, NavigationHandler classes escondidas, mas a maioria dos clientes não está ciente disso.
 * javax.faces.context.ExternalContext usa ServletContext, HttpSession, HttpServletRequest, HttpServletResponse e outras lá dentro.
 * 
 * Identificação: O Facade pode ser reconhecido em uma classe que possui uma interface simples, mas delega a maior parte do trabalho para outras classes. Geralmente, as fachadas gerenciam o ciclo de vida completo dos objetos que usam.
 * 
 * 
 * Interface simples para uma biblioteca de conversão de vídeo complexa:
 * Neste exemplo, o Facade simplifica a comunicação com uma estrutura complexa de conversão de vídeo.
 * 
 * O Facade fornece a uma única classe com um método único que lida com toda a complexidade de configurar as classes corretas da estrutura e recuperar o resultado em um formato correto.
 */
public class Main {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
    }
}
