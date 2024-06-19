//FACADE é uma interface frontal que mascara um código estrutural subjacente complexo, ocultando a interação entre as classes atrás de um ponto de acesso único e simplificado

public class Main {
    public static void main(String[] args) {
        DatabaseService dbService = new DatabaseService();
        User user = dbService.getUser("2");
        CryptoFactory.getCryptoService("BTC").buyCurrency(user, 1000);
        //se precisar usar esse mesmo código em outros lugares terá de ser copiado e colado lá
        //o ideal é ter uma interface central que todos que precisarem acessar vão acessar essa interface, e não ficar duplicando código
        //e tambem essa interface central é quem deve acessar os services e métodos e o cliente não acessa
        //precisa então de uma FACHADA (FACADE), uma interface simplificada que contém toda a lógica interna de um conjunto de classes

        //agora o cliente acessa a FACADE em vez de ter toda lógica 
        //o cliente usa a FACHADA em vez de chamar os objetos do subsistema diretamente e lidar diretamente com as classes
        //a parte de buscar o usuário, enviar email, transferir dinheiro fica dentro do facade
        BuyCryptoFacade buyCryptoFacade = new BuyCryptoFacade();
        buyCryptoFacade.buyCryptoFacade(1000, "BTC");
    }
}
