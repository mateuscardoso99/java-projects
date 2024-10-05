package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
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

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.example.Alice.ObjetoEnvio;

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
//alice vai escolher um arquivo, criptografá-lo usando a criptografia simétrica
//e usa-rá a chave publica recebida de bob para criptografar a chave simétrica
//bob vai usar sua chave privada para descriptografar a chave simétrica
//depois usa a chave simétrica pra descriptografar o conteúdo
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
        
        
        //espera receber o arquivo
        //a criptografia assimétrica é usada apenas para encriptar/desebcriptar a chave simétrica
        //no mais o processo todo é com criptografia simétrica
        //por causa da limitação do algoritmo RSA
        try(ServerSocket ss = new ServerSocket(5555)){
            System.out.println("[BOB] aguardando conexão porta 5555");

            Socket s = ss.accept();

            System.out.println("[BOB] conexão recebida");
            
            ObjectInputStream oi = new ObjectInputStream(s.getInputStream());
            ObjetoEnvio dadosRecebidos = (ObjetoEnvio) oi.readObject();
            
            System.out.println("[BOB] texto criptografado criptografia simetrica recebido: " + new String(dadosRecebidos.getTextoCifrado(), StandardCharsets.UTF_8));
            System.out.println("[BOB] chave simetrica criptografada recebida: " + new String(dadosRecebidos.getChaveSimetricaCriptografada(), StandardCharsets.UTF_8));
            
            //desencripta a chave simétrica com a chave privada
            byte[] chaveSimetricaDescriptografada = descriptografaChaveSimetrica(dadosRecebidos.getChaveSimetricaCriptografada(), privateKey);

            SecretKey secretKey = new SecretKeySpec(chaveSimetricaDescriptografada, "AES");
            Cipher cipherAES = Cipher.getInstance("AES");

            //depois de desencriptar a chave simétrica usa ela para desencriptar o conteúdo
            cipherAES.init(Cipher.DECRYPT_MODE, secretKey);//critografia simétrica usa a mesma chave pra encriptar/desencriptar, então precisa passar qual modo se deseja, nesse caso encriptar
            byte[] textoPuro = cipherAES.doFinal(dadosRecebidos.getTextoCifrado());//criptografa o texto puro e retorna o texto cifrado
            System.out.println("[BOB] texto puro: " + new String(textoPuro, StandardCharsets.UTF_8));
        }
    }

    public static byte[] descriptografaChaveSimetrica(byte[] textoCifrado, PrivateKey chavePrivada) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
        Cipher cipherRSA = Cipher.getInstance("RSA");
        cipherRSA.init(Cipher.DECRYPT_MODE, chavePrivada);//desencriptar usando a chave privada
        byte[] chaveSimetricaDescriptografada = cipherRSA.doFinal(textoCifrado);//desencripta
        System.out.println("[BOB] chave simetrica descriptografada: " + new String(chaveSimetricaDescriptografada, StandardCharsets.UTF_8));
        return chaveSimetricaDescriptografada;
    }
}
