package com.example;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

//criptografia assimétrica também chamada de "criptografia de chave pública"

/*
 * Uma chave pública é uma chave que é fornecida ao mundo exterior. 
 * Qualquer um que queira lhe enviar uma mensagem secreta criptografará a mensagem usando sua chave pública e 
 * então enviará o texto cifrado para você.
 * Uma chave privada é uma chave que você não compartilha com ninguém. 
 * As chaves privada e pública são matematicamente relacionadas. 
 * Então, se você receber um texto cifrado que foi criptografado usando sua chave pública, 
 * somente sua chave privada tem a capacidade de descriptografar o texto cifrado. 
 * Você não pode criptografar e descriptografar a mensagem com a chave pública, e o 
 * mesmo vale para a chave privada.
 */

//bob vai enviar sua chave pública para alice
//alice vai escolher um arquivo e vai usar a chave pública para criptografar esse arquivo e enviar para bob
//bob vai usar sua chave privada para descriptografar o arquivo
public class Bob {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        //usando sockets

        //cria o par de chaves (pública e privada)
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        //no algoritmo RSA os tamanhos das chaves são geralmente um dos seguintes: 512, 1024, 2048 ou 4096 bits .
        //Quanto mais bytes a chave tiver, mais segura será a criptografia. No entanto, quanto mais bytes a chave tiver, mais poder de computação será necessário para gerar a chave
        
        //OBS:
        //RSA tem restrições sobre o tamanho dos dados que podem ser criptografados de uma só vez. 
        //Em particular, o tamanho máximo dos dados que você pode criptografar com RSA é baseado no tamanho da chave 
        //menos o tamanho do padding utilizado.
        //Para uma chave RSA de 2048 bits (que equivale a 256 bytes), o tamanho máximo de dados que se pode criptografar é cerca de 256 bytes menos o tamanho do padding
        //RSA trabalha com exponenciação modular e, portanto, é restrito a mensagens que estão dentro desse tamanho.
        //o texto cifrado deve ser precisamente 2048 / 8 = 256 bytes, 
        //Isso restringe o valor de entrada para criptografia e, por sua vez, limita o tamanho da mensagem que pode ser processada
        //no caso se a mensagem passar de 256 bytes não vai ser processada gerando IllegalBlockSizeException
        //SE O ARQUIVO OU MENSAGEM TIVER MENOS DE 256 BYTES SERÁ FEITA CRIPTOGRAFIA/DESCRIPTOGRAFIA, SE TIVER MAIS SERÁ LANÇADO UMA IllegalBlockSizeException
        keyPairGenerator.initialize(2048);

        //gerar chaves
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        //pega as chaves pública e privada
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();


        //bob envia sua chave pública para alice
        Socket socket = new Socket("localhost", 5550);
        ObjectOutputStream ou = new ObjectOutputStream(socket.getOutputStream());
        ou.writeObject(publicKey);
        socket.close();
        
        
        //espera receber o arquivo e quando receber descriptografa usando a chave privada
        try(ServerSocket ss = new ServerSocket(5555)){
            System.out.println("[BOB] aguardando conexão porta 5555");

            Socket s = ss.accept();

            System.out.println("[BOB] conexão recebida");
            
            List<String> conteudoArquivo = new ArrayList<>();
            byte[] pedacosArquivo = new byte[256];//tamanho máximo para criptografar/descriptografar é [tamanho da chave] / 8
            int read;

            //descriptografa cada pedaço do arquivo que foi criptografado e enviado por alice e adiciona o conteúdo num arraylist
            while((read = s.getInputStream().read(pedacosArquivo)) != -1){
                System.out.println("[BOB] texto cifrado recebido: " + new String(pedacosArquivo, StandardCharsets.UTF_8));
                processaParteCriptografadaDoArquivo(pedacosArquivo, privateKey, conteudoArquivo);
            }

            //conteudo descriptografado
            System.out.println("\n\nCONTEUDO ARQUIVO\n\n");
            conteudoArquivo.stream().forEach(System.out::println);
        }
    }

    public static void processaParteCriptografadaDoArquivo(byte[] textoCifrado, PrivateKey chavePrivada, List<String> conteudoArquivo) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
        Cipher cipherRSA = Cipher.getInstance("RSA/ECB/NoPadding");
        cipherRSA.init(Cipher.DECRYPT_MODE, chavePrivada);//desencriptar usando a chave privada
        byte[] textoPuro = cipherRSA.doFinal(textoCifrado);//desencripta
        System.out.println("[BOB] texto puro: " + new String(textoPuro, StandardCharsets.UTF_8));
        conteudoArquivo.add(new String(textoPuro, StandardCharsets.UTF_8));
    }
}
