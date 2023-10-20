package tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//outputstream do cliente está ligado ao inputstream do servidor
//outputstream do servidor está ligado ao inputstream do cliente
class Cliente{
    public static void main(String[] args) throws IOException{
        // //while(true){
        Socket conexao = new Socket();//cria uma conexão com o servidor
        conexao.connect(new InetSocketAddress("localhost", 8081));
        conexao.getOutputStream().write("PING".getBytes());//envia dados pro servidor

        byte[] buffer = new byte[100];
        conexao.getInputStream().read(buffer);//recebe dados do servidor
        System.out.println(new String(buffer, 0, buffer.length, StandardCharsets.UTF_8));
        conexao.close();//fecha conexão com o servidor (fecha o socket), se o cliente conectar denovo terá que criar um novo socket
            
        //     //t2 = System.currentTimeMillis();
        //     System.out.println("Pinging "+soc.getInetAddress()+" with string "+str );
        //     System.out.println("Reply from "+soc.getInetAddress() +" String "+str1+" Length : "+str1.length());
        //     System.out.println("Sent : "+str.length()+" Received : "+str1.length()+" Lost : "+(str.length()-str1.length()));
            //System.out.println("Approx. Time in Milliseconds  = "+(t2-t1));
    }
}
