package br.ufsm.poli.csi.cripto.assimetrico;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class Bob {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(16000);
        System.out.println("Gerando par de chaves...");
        KeyPair keyPair = kpg.generateKeyPair();
      
        ServerSocket ss = new ServerSocket(5555);
        System.out.println("[BOB] Aguardando conexão na porta 5555.");
        Socket s = ss.accept();
        System.out.println("[BOB] Conexão recebida.");
      
        ObjectOutputStream oout = new ObjectOutputStream(s.getOutputStream());
        oout.writeObject(keyPair.getPublic());//bob envia sua chave publica pra alice

        ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
        ObjetoTroca objetoTroca = (ObjetoTroca) oin.readObject();

        Cipher cipherRSA = Cipher.getInstance("RSA");
        cipherRSA.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] textoPlano = cipherRSA.doFinal(objetoTroca.getArquivoCriptografado());//bob descriptografa usando sua chave privada

        System.out.println("[BOB] Texto plano decifrado: " + new String(textoPlano));


    }


}
