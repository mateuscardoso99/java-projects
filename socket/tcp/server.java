package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
ServerSocket é um ouvinte que aguarda o estabelecimento de conexões de soquete. 
Socket é o canal de comunicação entre dois sistemas (um servidor e outro cliente)
quando um pacote é recebido ou enviado é criada uma nova conexão (novo socket) com o remetente ou destinatario 
dessa forma os envios e recebimentos seguintes serão sempre por esse socket
um socket possui IP de origem e destino e porta de origem e destino
ao contrário do UDP em que existe um socket apenas que recebe pacotes de todos no TCP existe um socket pra cada conexão
*/
class Server{
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket conexao = serverSocket.accept();
        byte[] buffer = new byte[100];
        conexao.getInputStream().read(buffer);
        System.out.println(new String(buffer, 0, buffer.length));
        conexao.getOutputStream().write("PONG".getBytes());
        conexao.close();
        serverSocket.close();
    }
}
