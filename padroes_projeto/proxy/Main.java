package br.ufsm.csi.pp.exercicio4_1;


/**
 * Às vezes um objeto cliente pode não ser capaz de acessar um objeto provedor de serviços por meios normais. 
 * Isso pode acontecer por uma variedade de razões: 
 * A localização do objeto de destino: 
 * – O objeto de destino pode estar presente em um espaço de endereçamento diferente no mesmo ou em um computador diferente. 
 * O estado de existência do objeto de destino: 
 * – O objeto de destino pode não existir até que ele seja realmente necessário para renderizar um serviço; 
 * – O objeto pode estar em uma forma compactada. 
 * Comportamento especial: 
 * – O objeto de destino pode oferecer ou negar serviços com base nos privilégios de acesso de seus objetos de cliente. 
 * – Alguns objetos do provedor de serviços podem precisar de consideração especial quando usados em um ambiente multithread.
 * 
 * Em tais casos, em vez de ter objetos cliente para lidar com os requisitos especiais para acessar o objeto de destino, 
 * o padrão Proxy sugere usar um objeto separado “Proxy” para fornecer um meio para diferentes objetos cliente para acessar o 
 * objeto alvo em uma forma simples.
 * – O objeto Proxy oferece (IMPLEMENTA) a mesma interface que o objeto de destino
 * – O objeto Proxy interage com o objeto de destino em nome de um objeto de cliente e cuida dos detalhes específicos de comunicação com o objeto de destino. 
 * – Objetos de cliente nem mesmo precisam saber que eles estão lidando com Proxy para o objeto original. 
 */










 /**
  * Implementar um Proxy para uma classe que acessa um banco de dados, podendo realizar consultas SQL, 
  * além de todos os outros comandos suportados através da implementação da interface.

  * public interface Database {
  *      String query(String sql);
  *      void authenticate(String username, String password);
  * } 
  
  * Você deverá implementar um proxy “SecureDatabase” para a interface “Database”, que recebe um RealDatabase no construtor, e 
  * que permite apenas a execução de comandos SELECT para clientes não devidamente autenticados.
  */
public class Main {

    public static void main(String[] args) {
        RealDatabase database = new RealDatabase();
        SecureDatabase secureDatabase = new SecureDatabase(database);
        database.query("INSERT into usuarios ('lallala', 'lalala');"); //autorizado pois não passou pelo proxy
        secureDatabase.query("INSERT into usuarios ('lallala', 'lalala');"); //não autorizado, pois o proxy não deixa passar
        secureDatabase.query("Select * from usuarios;"); //autorizado
        secureDatabase.authenticate("root", "senha");
        secureDatabase.query("INSERT into usuarios ('lallala', 'lalala');"); //autorizado, pois foi autenticado na linha acima
    }

}
