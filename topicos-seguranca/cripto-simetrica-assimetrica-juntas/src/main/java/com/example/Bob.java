package br.ufsm.poli.csi.cripto;

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

        //gera as chaves
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Socket socket = new Socket("localhost", 5560);
        
        //envia chave pra alice
        EnvioChavePublica ei = new EnvioChavePublica();
        ei.setPublicKey(keyPair.getPublic());

        ObjectOutputStream ou = new ObjectOutputStream(socket.getOutputStream());
        ou.writeObject(ei);
        

        ServerSocket ss = new ServerSocket(5555);
        System.out.println("[BOB] Aguardando conexão na porta 5555.");
        Socket s = ss.accept();
        System.out.println("[BOB] Conexão recebida.");

        //recebe a chave simetrica criptografada e o arquivo criptografado com cripto assimetrica
        ObjectInputStream oi = new ObjectInputStream(s.getInputStream());
        ObjetoTroca objetoTroca = (ObjetoTroca) oi.readObject();

        //descriptografa a chave simetrica
        Cipher cipherRSA = Cipher.getInstance("RSA");
        cipherRSA.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        cipherRSA.update(objetoTroca.getChaveSimetricaCriptografada());
        byte[] chaveSimetricaDescriptografada = cipherRSA.doFinal();

        //converte os bytes da chave simetrica descriptografada para a chave simetrica
        SecretKey chaveSimetrica = new SecretKeySpec(chaveSimetricaDescriptografada, "AES");

        Cipher cipherAES = Cipher.getInstance("AES");
        cipherAES.init(Cipher.DECRYPT_MODE, chaveSimetrica);

        byte[] textoPlano = cipherAES.doFinal(objetoTroca.getArquivoCriptografiaSimetrica());

        System.out.println("[BOB] Texto plano decifrado: " + new String(textoPlano, "UTF8"));


    }


}
