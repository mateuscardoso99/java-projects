package com.example;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

//criptografia assimétrica também chamada de "criptografia de chave pública"
//alice vai receber a chave pública de bob
//escolher um arquivo, criptografá-lo usando a chave publica e enviar para bob

//obs: algoritmos de cifra requerem bytes para executar a criptografia/descriptografia
public class Alice {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
        PublicKey chavePublica = null;

        //bob vai enviar sua chave pública para alice
        try(ServerSocket serverSocket = new ServerSocket(5550)){
            System.out.println("[ALICE] aguardando chave pública porta 5550");

            Socket socket = serverSocket.accept();

            ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());

            chavePublica = (PublicKey) oi.readObject();

            System.out.println("CHAVE PÚBLICA RECEBIDA. ALGORITMO: " + chavePublica.getAlgorithm());
        }
        
        
        JFileChooser fc = new JFileChooser("");
        System.out.println("SELECIONANDO ARQUIVO");
        JFrame jFrame = new JFrame();
        int retorno = fc.showDialog(jFrame, "OK");//se um arquivo foi escolhido retorna JFileChooser.APPROVE_OPTION
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            FileInputStream fis = new FileInputStream(f);
            System.out.println("ARQUIVO SELECIONADO");
            
            byte[] bytes = new byte[256];
            int dataRead;// = fis.read(bytes);

            BufferedInputStream b = new BufferedInputStream(fis);

            Socket s = new Socket("localhost", 5555);

            /*
             * como bob usa o algoritmo RSA que processa no máximo 256 bytes para uma chave de 2048 bits
             * e o arquivo tem mais de 256 bytes, é preciso quebrá-lo em partes de 256 bytes e enviar essas partes uma por vez
             * dessa forma bob descriptografa cada uma dessas partes e tudo funciona
             */
            while((dataRead = b.read(bytes)) != -1){
                Cipher cipherRSA = Cipher.getInstance("RSA/ECB/NoPadding");
            
                cipherRSA.init(Cipher.ENCRYPT_MODE, chavePublica);
                byte[] textoCifrado = cipherRSA.doFinal(bytes);//criptografa o texto puro e retorna o texto cifrado
                
                System.out.println("[ALICE] texto puro: " + new String(bytes, StandardCharsets.UTF_8));
                System.out.println("[ALICE] texto cifrado: " + new String(textoCifrado, StandardCharsets.UTF_8));
                            
                s.getOutputStream().write(textoCifrado);

                dataRead = fis.read(bytes);//coloca o inputStream (fluxo de bytes) para dentro do biteArray
            }

            fis.close();            
            s.close();
        }
        jFrame.dispose();
    }
}
