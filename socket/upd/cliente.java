package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class cliente {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket(8081,InetAddress.getByName("localhost"));
        byte[] b = "PING".getBytes();

        DatagramPacket pacoteEnviado = new DatagramPacket(b, b.length, InetAddress.getByName("localhost"),8080);
        socket.send(pacoteEnviado);

        b = new byte[100];

        DatagramPacket pacoteRecebido = new DatagramPacket(b,b.length);
        socket.receive(pacoteRecebido);
        System.out.println(new String(pacoteRecebido.getData()));
        socket.close();
    }
}
