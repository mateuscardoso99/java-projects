import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            //aguarda clientes se conectarem, fica bloqueado nessa linha até alguém se conectar, então executa as linhas abaixo
            //se mais de 1 cliente se conectar, ele vai ficar esperando o servidor processar o socket do primeiro cliente
            //o certo é usar threads pra que o processamento seja simultaneo
            //podia usar a classe DataInputStream pra ler os dados em tipos primitivos em vez de bytes puros

            byte[] bytes = new byte[4];
            //se fosse new byte[1] leria só uma letra por vez no loop, new byte[3] ia ler "PIN" ou seja 3 bytes por vez
            //ou seja, ia precisar executar o while outra vez pra ler toda a mensagem, e depois de ler bloqueia denovo no read()
            //até que chegue uma nova msg
            //como é 4 consegue ler toda a palavra no loop, pois "PING" tem 4 bytes
            //se a mensagem couber dentro do byte array será lida integralmente, senão, será lida em pedaços
            //outra forma seria usar caracteres que marcam o fim da msg como "\n"
            int n;
            while ((n = socket.getInputStream().read(bytes)) != -1) {//retorna -1 quando a conexão é fechada, (socket é fechado)
                System.out.println(new String(bytes,StandardCharsets.UTF_8));
                socket.getOutputStream().write("PONG".getBytes());//manda msg pro cliente
            }
            System.out.println("SOCKET FECHADO PELO CLIENTE");
        }
    }
}
