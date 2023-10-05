package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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