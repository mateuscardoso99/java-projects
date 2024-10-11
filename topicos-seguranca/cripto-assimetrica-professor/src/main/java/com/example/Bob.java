package br.ufsm.poli.csi.cripto.assimetrico;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
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
        kpg.initialize(2048);
        System.out.println("[BOB] Gerando par chaves...");
        KeyPair parChaves = kpg.generateKeyPair();

        ServerSocket ss = new ServerSocket(5555);
        System.out.println("[BOB] Aguardando conexão na porta 5555.");
        Socket s = ss.accept();
        System.out.println("[BOB] Conexão recebida.");

        //enviando a chave publica para a Alice
        ObjetoTroca objetoTroca = new ObjetoTroca();
        objetoTroca.setKey(parChaves.getPublic());
        ObjectOutputStream oout = new ObjectOutputStream(s.getOutputStream());
        oout.writeObject(objetoTroca);

        ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
        objetoTroca = (ObjetoTroca) oin.readObject();

        Cipher cipherRSA = Cipher.getInstance("RSA");
        cipherRSA.init(Cipher.DECRYPT_MODE, parChaves.getPrivate());

        byte[] bChaveSessao = cipherRSA.doFinal(objetoTroca.getChaveSessao());
        SecretKey chaveSessao = new SecretKeySpec(bChaveSessao, "AES");

        Cipher cipherAES = Cipher.getInstance("AES");
        cipherAES.init(Cipher.DECRYPT_MODE, chaveSessao);
        byte[] textoPlano = cipherAES.doFinal(objetoTroca.getArquivoCriptografado());

        System.out.println("[BOB] Texto plano decifrado: " + new String(textoPlano));

    }


}
