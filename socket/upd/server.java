package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

//udp: não é orientado a conexão (não é feita uma conexão prévia (handshake)), apenas envia o pacote sem garantia de entrega
//no upd todos os paoctes são recebidos por um único socket ao contrario do TCP que existe um socket pra cada conexão
//o udp diferencia os remetentes dos pacotes pelo IP
class server {
    public static void main(String[] args) throws IOException{
        DatagramSocket serverSocket = new DatagramSocket(8080);
        byte[] b = new byte[100];

        DatagramPacket pacoteRecebido = new DatagramPacket(b, b.length);
        serverSocket.receive(pacoteRecebido);
        System.out.println(new String(pacoteRecebido.getData(), StandardCharsets.UTF_8));

        InetAddress enderecoCliente = pacoteRecebido.getAddress();
        int porta = pacoteRecebido.getPort();

        b = "PONG".getBytes();
        DatagramPacket enviarPacote = new DatagramPacket(b, b.length,enderecoCliente,porta);
        serverSocket.send(enviarPacote);
        serverSocket.close();
    }
}
