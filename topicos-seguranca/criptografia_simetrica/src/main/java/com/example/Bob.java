package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.example.Alice.ObjetoEnvio;

public class Bob {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        //usando sockets
        try(ServerSocket ss = new ServerSocket(5555)){
            System.out.println("[BOB] aguardando conexão porta 5555");

            Socket s = ss.accept();

            System.out.println("[BOB] conexão recebida");
            
            ObjectInputStream oi = new ObjectInputStream(s.getInputStream());
            ObjetoEnvio dados = (ObjetoEnvio) oi.readObject();
            recebeArquivoCriptografado(dados.getTextoCifrado(), dados.getChave());
        }
    }

    public static void recebeArquivoCriptografado(byte[] textoCifrado, SecretKey chave) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException{
        byte[] textoPuro = null;
        Cipher cipherAES = Cipher.getInstance("AES");
        cipherAES.init(Cipher.DECRYPT_MODE, chave);//critografia simétrica usa a mesma chave pra encriptar/desencriptar, então precisa passar qual modo se deseja, nesse caso desencriptar
        textoPuro = cipherAES.doFinal(textoCifrado);//desencripta
        System.out.println("[BOB] texto plano decifrado: " + new String(textoPuro, StandardCharsets.UTF_8));
    }
}
