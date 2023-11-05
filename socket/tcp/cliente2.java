import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class cliente {
    public static void main(String[] args) throws IOException, InterruptedException{
        Socket clientSocket = new Socket("localhost", 8080);

        //simulação cliente enviando mensagens por um tempo
        byte[] dados = new byte[4];
        int i = 0;
        while (i < 10) {
            clientSocket.getOutputStream().write("PING".getBytes());
            clientSocket.getInputStream().read(dados);
            System.out.println(new String(dados,StandardCharsets.UTF_8));
            Thread.sleep(2000);//envia msg a cada 2 segundos
            i++;
        }
        clientSocket.close();
    }
}
