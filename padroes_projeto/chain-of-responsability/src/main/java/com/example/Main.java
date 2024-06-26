package com.example;

/**
 * CHAIN OF RESPONSIBILITY (cadeia de responsabilidades)
 * 
 * Aplicando o padrão CoR, cada um desses objetos pode ser organizado na forma de uma cadeia, com cada objeto tendo um ponteiro para o próximo objeto na cadeia. 
 * O primeiro objeto na cadeia recebe a solicitação e decide atender a solicitação ou passá-lo para o próximo objeto na cadeia. 
 * O pedido flui através de todos os objetos na cadeia um após o outro até que a solicitação seja tratada por um dos servidores na cadeia 
 * Ou então o pedido chega ao final da cadeia sem ser processado
 * 
 * O conjunto de potenciais objetos manipuladores de solicitação e a ordem em que esses objetos formam a cadeia podem ser decididos dinamicamente pelo cliente
 * 
 * CoR fornece uma maneira de tomar decisões com um fraco acoplamento. 
 * A estrutura de cadeia não possui qualquer informação sobre as classes que compõem a cadeia; 
 * 
 * Da mesma forma, uma classe da cadeia não tem nenhuma noção sobre o formato da estrutura ou sobre elementos nela inseridos.
 * 
 * Existe uma relação de hierarquia (children/parent)
 */
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Handler handler = new UsuarioExisteHandler(database);//1° handler nesse exemplo será UsuarioExisteHandler
                
        //OBS: embora handler seja do tipo Handler.class, ele recebeu uma instancia de UsuarioExisteHandler.class então ao chamar setNextHandler() abaixo 
        //chamará o setNextHandler() da classe UsuarioExisteHandler pois ele recebe por herança da class abstrata Handler.class

        handler.setNextHandler(new ValidPasswordHandler(database)) //seta o próximo handler de UsuarioExisteHandler será ValidPasswordHandler
                .setNextHandler(new RoleCheckHandler()); //o setNextHandler() acima recebeu o ValidPasswordHandler e retornou a instancia do próprio ValidPasswordHandler, então ao chamar setNextHandler() nesta linha aqui, vai chamar o setNextHandler() de ValidPasswordHandler, então o próximo manipulador de ValidPasswordHandler será RoleCheckHandler

        AuthService service = new AuthService(handler);
        //recebe o handler com os manipuladores da cadeia já configurados

        System.out.println("==========================================");

        System.out.println(service.login("username", "35643564"));

        System.out.println("==========================================");

        System.out.println(service.login("user_username", "1234"));

        System.out.println("==========================================");

        System.out.println(service.login("admin_username", "12345678"));

        System.out.println("==========================================");
    }
}
