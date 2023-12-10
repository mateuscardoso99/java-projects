package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
ServerSocket é um ouvinte que aguarda o estabelecimento de conexões de soquete. 
Socket é o canal de comunicação entre dois sistemas (um servidor e outro cliente)
quando um pacote é recebido ou enviado é criada uma nova conexão (novo socket) com o remetente ou destinatario 
dessa forma os envios e recebimentos seguintes serão sempre por esse socket até que um dos lados feche o seu socket encerrando a conexão
um socket possui IP de origem e destino e porta de origem e destino
ao contrário do UDP em que existe um socket apenas que recebe pacotes de todos, no TCP existe um socket pra cada conexão entre um cliente e o servidor
e todas as mensagens são enviadas/recebidas por esse socket

Cada socket é identificado com uma tupla quádrupla: (endereço IP de origem, número da porta de origem, endereço IP de destino, número da porta de  destino).  
Quando  o  host  C  recebe  um  datagrama  IP  ele  examina  estes  quatro  campos no pacote para determinar a qual socket ele deve entregar os dados do 
segmento TCP. Assim, as requisições de A e B passam através de sockets diferentes. 
O identificador para ambos os sockets tem a porta 8081 como destino, no entanto, os identificadores para estes sockets têm diferentes valores para o IP de origem.
*/
class Server{
    public static void main(String[] args) throws IOException{
        //poderia ter um while(true) no cliente e outro no servidor pra troca de mensagens por esse socket até que alguma parte feche a conexão
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket conexao = serverSocket.accept();//recebe conexão de um cliente qualquer e cria um socket pra comunicar-se com esse cliente
        byte[] buffer = new byte[100];
        conexao.getInputStream().read(buffer);//recebe mensagem do cliente
        System.out.println(new String(buffer, 0, buffer.length));
        conexao.getOutputStream().write("PONG".getBytes());//envia pro cliente
        conexao.close();//fecha conexão com o cliente (fecha o socket), se o cliente conectar denovo será criado um novo socket independente
        serverSocket.close();
    }
}
