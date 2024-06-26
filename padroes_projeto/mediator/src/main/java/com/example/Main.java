package com.example;

/**
 * MEDIATOR (mediador)
 * 
 * ex: torre de controle de um aeroporto faz a mediação para o pouso e decolagem de vários aviões
 * os aviões não falam diretamente entre si, mas se comunicam com a torre
 * 
 * Aplicações orientadas a objetos consistem em um conjunto de objetos que interagem uns com os outros com a finalidade de fornecer um serviço. 
 * À medida que o número de objetos aumenta, esse tipo de interação direta pode levar a um complexo labirinto de referências; O que afeta a capacidade de manutenção da aplicação. 
 * Além disso, ter um objeto que se refere diretamente a outros objetos reduz muito o escopo para reutilizar esses objetos por causa de maior acoplamento
 * 
 * O padrão Mediator sugere abstrair todos os detalhes da interação do objeto em uma classe separada.
 * 
 * Cada objeto do grupo ainda é responsável por oferecer o serviço para o qual foi projetado, porém: 
 * Os objetos não interagem uns com os outros diretamente para essa finalidade. 
 * A interação entre dois objetos diferentes é encaminhada através da classe Mediator. 
 * Todos os objetos enviam suas mensagens para o Mediator. 
 * O Mediator envia mensagens para os objetos apropriados de acordo com os requisitos da aplicação. 
 * 
 * Exemplo: numa interface gráfica, componentes podem precisar interagir entre eles. 
 * Dependendo do valor de um campo, outros podem ser habilitados/desabilitados. 
 * A medida que a interface fica complexa, este projeto pode ficar caótico
 * 
 * Solução: Todos os componentes enviam seus eventos ao mediador (Dialog), que implementa a chamada aos outros componentes que podem reagir a aquele evento
 * 
 * ESTE PADRÃO RESTRINGE A COMUNICAÇÃO DIRETA ENTRE OBJETOS E OS FORÇA A COMUNICAR-SE POR MEIO DO OBJETO MEDIADOR, REDUZINDO AS DEPENDÊNCIAS ENTRE ELES
 * 
 * este padrão permite extrair todos os relacionamentos entre classes ou componentes em uma classe separada, dees jeito os
 * componentes individuais (ForgotPasswordButton e LoginButton) deixarão de ter conhecimento de outros componentes, dissociando-os uns dos outros
 * eles ainda serão capazes de se comunicar entre si, mas indiretamente por meio do objeto mediador (Dialog.class)
 */
public class Main {
    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.enterUsername("Geekific");
        dialog.enterPassword("LikeAndSubscribe");

        dialog.simulateLoginClicked();

        dialog.simulateForgotPassClicked();

    }
}
